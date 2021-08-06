package com.test01;

public class MessageBeanImpl implements MessageBean {
	
	private String fruit;
	private int cost;

	@Override
	public void sayHello() {
		System.out.println("과일이름: " + fruit + "\t" + "가격 : " + cost);
	}
	
	public MessageBeanImpl() {
	}
	
	public MessageBeanImpl(String fruit, int cost) {
		this.fruit = fruit;
		this.cost = cost;
	}

}
