package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		TV samsong = (TV) factory.getBean("samsong");
		TV lz = (TV) factory.getBean("lzTV");
		
		samsong.powerOn();
		lz.powerOff();
	}

}
