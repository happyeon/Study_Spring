package com.mvc.mapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.mapping.dto.AddressDto;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/command.do", method=RequestMethod.GET)
	public String getCommand(Model model, String name, @RequestParam("addr") String address, String phone) {
		// 이름이 같으면 생략 가능. 이름이 다르면 @RequestParam을 사용해서 지정해준다. ("addr"로 넘어온 변수가 address 변수에 저장될 거야)
		
		
		model.addAttribute("dto", new AddressDto(name, address, phone));
		
		// return해준 문자열은 view name이 된다.
		// servlet-context.xml에서 view name을 받아서 ViewResolver가 view name 앞뒤에 prefix, suffix로 지정해준 것들을 붙여서 view를 찾는다.
		return "getcommand";	
	}
	
	@RequestMapping(value="/command.do", method=RequestMethod.POST)
	public String postCommand(Model model, @ModelAttribute AddressDto dto) {
		
		model.addAttribute("dto", dto);
		
		return "postCommand";
	}
	
}
