package com.edu.entity;

public class Rectangle extends Shape {

	public Rectangle() {
	}

	public Rectangle(String title, int data1, int data2) {
		super(title, data1, data2);
	}

	@Override
	public void viewSize() {
		System.out.println(title + "의 넓이 : " + data1*data2);
	}

}
