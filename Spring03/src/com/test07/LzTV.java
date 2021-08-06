package com.test07;

public class LzTV implements TV {

	public LzTV() {
		System.out.println("lz tv 생성!!");
	}

	@Override
	public void powerOn() {
		System.out.println("lz tv power on");
	}

	@Override
	public void powerOff() {
		System.out.println("lz tv power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("lz tv volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("lz tv volume down");
	}

}
