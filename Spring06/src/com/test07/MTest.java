package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
		
		MessageBean bean = factory.getBean("proxy", MessageBean.class);
		bean.sayHello();
	}

}

//com.test 2, 7은 어려우니 넘어가도 됨