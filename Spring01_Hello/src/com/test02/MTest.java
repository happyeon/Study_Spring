package com.test02;

public class MTest {

	public static void main(String[] args) {
		// 약결합 (인터페이스를 통해 한 단계를 거쳐 실행되기 때문에 결합도가 낮아졌다)
		
		MessageBean bean = new MessageBeanEn();
		bean.sayHello("Spring");

		bean = new MessageBeanKo();
		bean.sayHello("스프링");
	}
	
}
