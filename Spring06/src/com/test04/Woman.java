package com.test04;

public class Woman implements Person {

	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜서 웹서핑을 한다.");
		return "스프링";
	}

}
