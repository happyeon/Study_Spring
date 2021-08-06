package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		// bean으로 등록된 2명 출력
		Address p1 = (Address) factory.getBean("p1");
		Address p2 = (Address) factory.getBean("p2");
		// 어떤 타입인지 모르기 때문에 오브젝트로 감싸서 리턴해준다.
		
		System.out.println(p1);
		System.out.println(p2);
	}

}
