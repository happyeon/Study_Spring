package com.file.updown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.file.updown.util.FileValidator;
import com.file.updown.util.UploadFile;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	

	
	
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
		// uploadFile에 대한 유효성 검사
		fileValidator.validate(uploadFile, result);
		System.out.println("업로드파일 : " + uploadFile);
		
		if (result.hasErrors()) {    // 업로드할 파일을 선택하지 않은 경우 form에 에러 메세지를 출력
			return "upload";
		}
		
		// dto에서 MultipartFile을 받아온다.
		MultipartFile file = uploadFile.getMpfile();
		String name = file.getOriginalFilename();
		
		UploadFile fileObj = new UploadFile();
		fileObj.setName(name);
		fileObj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = file.getInputStream();
			// getRealPath : 서블릿 컨테이너에서 제공하는대로 웹 응용 프로그램 내에서 지정된 경로의 실제 경로를 반환
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			System.out.println("업로드 될 실제 경로 : " + path);
			
			
			File storage = new File(path);
			// 경로가 없으면 경로 생성(폴더)
			if(!storage.exists()) {
				storage.mkdirs();
			}
			
			File newFile = new File(path + "/" + name);
			// 해당 경로에 파일이 없으면 생성
			if(!newFile.exists()) {
				newFile.createNewFile();
			}
			
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] b = new byte[(int)file.getSize()];
			
			// 입력 스트림으로부터 더 이상 바이트를 읽을 수 없으면 read()는 -1 리턴 
			while((read = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, read);    // b[0]부터 read 개의 바이트를 출력 스트림으로 보냄
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		// view에 전달할 데이터를 key, value 쌍으로 전달
		model.addAttribute("fileObj", fileObj);
		
		return "download";
	}
	
	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		byte[] down = null;
		
		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");   // 경로 설정
			File file = new File(path + "/" + name);    // 업로드 경로가 저장된 파일 객체
			
			down = FileCopyUtils.copyToByteArray(file);  // file의 내용을 새로운 byte[]로 복사
			
			// file encoding 설정
			String filename = new String(file.getName().getBytes(), "8859_1");  // 한글은 http 헤더에 사용할 수 없기 때문에 파일명은 영문으로 인코딩하여 헤더에 적용
			
			// file download 설정
			response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");   // 다운로드 파일에 대한 설정, Content-Disposition 헤더에 파일 이름 세팅
			response.setContentLength(down.length);   // 파일 크기 설정
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return down;
	}
	
}
