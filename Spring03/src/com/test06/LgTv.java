package com.test06;

public class LgTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("LG tv power on");
	}

	@Override
	public void powerOff() {
		System.out.println("LG tv power off");
	}

	@Override
	public void volumeUP() {
		System.out.println("LG tv volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("LG tv volume down");
	}

}
