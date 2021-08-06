package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		// 등록된 bean 두 개 모두 출력
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Emp p1 = factory.getBean("p1", Emp.class);
		Emp p2 = (Emp) factory.getBean("p2");
		
		System.out.println(p1);
		System.out.println(p2);
	}

}
