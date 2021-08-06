package com.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {

	public void before(JoinPoint join) {
		System.out.println(join.getTarget().getClass()); // 호출되는 타켓의 타입
		System.out.println(join.getSignature().getName()); // 호출되는 메소드의 이름
		System.out.println("출석카드 찍는다.");
	}
	
	public void after() {
		System.out.println("집에 간다.");
	}
	
}
