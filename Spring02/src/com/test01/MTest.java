package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		// MessageBean Null = new MessageBean();
		MessageBean Null = (MessageBean) factory.getBean("null");		// 어떤 타입인지 모르기 때문에 오브젝트로 감싸서 리턴
		Null.sayHello();
		
		MessageBean apple = (MessageBean) factory.getBean("apple");
		apple.sayHello();
		
		MessageBean mango = (MessageBean) factory.getBean("mango");
		mango.sayHello();
		
		MessageBean banana = (MessageBean) factory.getBean("banana");
		banana.sayHello();
	}
	
}
