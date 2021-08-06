package com.hello.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloBiz {
	
	@Autowired
	private HelloDao dao;
	
	public String getHello() {
		
		// TODO : 05. dao(@Repository) 호출
		// TODO : 07. biz에서 return
		return "Hello, " + dao.getHello();
	}

}
