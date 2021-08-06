package com.test06;

public class SamsungTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("samsung tv power on");
	}

	@Override
	public void powerOff() {
		System.out.println("samsung tv power off");
	}

	@Override
	public void volumeUP() {
		System.out.println("samsung tv volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("samsung tv volume down");
	}

}
