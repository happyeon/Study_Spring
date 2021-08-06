package com.edu.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

public class MyAspect {
	
	public void before() {
		System.out.println("도형의 넓이를 구한다.");
	}
	

	public void after() {
		System.out.println("도형의 넓이를 출력한다.");
	}
}
