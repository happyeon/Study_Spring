package com.test04;

public class Engineer {
	
	private Emp emp;
	private String dept;
	
	public Engineer() {
	}
	
	public Engineer(Emp emp, String dept) {
		this.emp = emp;
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return emp + " \t 기술 (" + dept + ")";
	}
	
	

}
