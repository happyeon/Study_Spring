package com.test06;

public class BeanFactory {
	
	Object getBean(String name) {
		if (name.equals("samsung")) {
			return new SamsungTv();
		} else if (name.equals("Lg")) {
			return new LgTv();
		}
		
		return null;
	}

}
