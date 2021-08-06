package com.test01;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractTest {
	
	// 추상 클래스 : new 연산자를 사용해서 객체 생성하지 못한다.
	// 추상 메소드 : body가 없는 메소드. 추상메소드를 가지고 있는 추상클래스를 가지고 있으면 반드시 구현해야 한다.
	public abstract String dayInfo();
	
	public static AbstractTest getInstance() {
		
		GregorianCalendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(day) {
		case 1: return new Sunday();
		case 2: return new Monday();
		case 3: return new Tuesday();
		case 4: return new Wednesday();
		case 5: return new Thursday();
		case 6: return new Friday();
		case 7: return new Saturday();
		}
		
		return null;
	}
	
}
