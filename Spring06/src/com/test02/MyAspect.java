package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object target = null;
		
		System.out.println("출석카드 찍는다.");
		
		try {
			target = invocation.proceed();
		} catch(Exception e) {
			System.out.println("쉬는 날 이었다.");
		} finally {
			System.out.println("집에 간다.");
		}
		
		return target;
	}

}
