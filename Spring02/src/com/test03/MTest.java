package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Address park = (Address) factory.getBean("park");
		Address kim = (Address) factory.getBean("kim");
		
		System.out.println(park);
		System.out.println(kim);
	}
	
}
