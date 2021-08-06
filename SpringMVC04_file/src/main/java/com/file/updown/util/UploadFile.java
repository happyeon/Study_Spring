package com.file.updown.util;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	
	// 커맨드 객체에 해당하는 클래스
	// form태그에서 path로 받아오는 property 와 연결
	private String name;
	private String desc;
	private MultipartFile mpfile;    // MultiparFile 변수 이름은 폼에서 fileUpload 하는 input 태그의 name으로 지정
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public MultipartFile getMpfile() {
		return mpfile;
	}
	public void setMpfile(MultipartFile mpfile) {
		this.mpfile = mpfile;
	}
	
	

}
