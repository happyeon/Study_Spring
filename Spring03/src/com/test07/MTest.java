package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
		
		TV lz = (TV) factory.getBean("lz");
		
		lz.powerOn();
		lz.powerOff();
		lz.volumeUp();
		lz.volumeDown();
	}

}

// samsong tv 생성!! 이 뜬 이유??
// ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml"); <- 여기서 spring ioc container 만들어졌다.
// xml에서 lazy-init="true" 만들어 놓으면 삼성티비 생성 안됨! 왜?
// lazy-init : 호출하기 전까지는 객체 생성 안됨. 필요할 때 만들게 해준다.
// lazy: 최대한 나중에 사용