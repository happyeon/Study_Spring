package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		Developer lee = (Developer) factory.getBean("leess");
		Engineer hong = factory.getBean("honggd", Engineer.class);
		
		System.out.println(lee);
		System.out.println(hong);
	}

}
