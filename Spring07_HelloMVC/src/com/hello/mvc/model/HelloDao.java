package com.hello.mvc.model;

import org.springframework.stereotype.Repository;

@Repository		// 다오를 객체로 만들어 준다. 클래스 내부에서 exception이 발생하면 data access exception으로 바꿔버린다.
public class HelloDao {
	
	public String getHello() {
		
		// TODO : 06. dao에서 return
		return "Spring";
	}

}
