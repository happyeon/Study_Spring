package com.test06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Before("myClass()")
	public void before() {
		System.out.println("출석카드를 찍는다.");
	}
	
	@After("myClass()")
	public void after() {
		System.out.println("집에 간다.");
	}
	
	@Pointcut("execution(public * *(..))")
	public void myClass() {
		// 사용 안해도 됨!
	}

}
