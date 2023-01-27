package com.te.springboot.abstraction;

public class Bike {

	public Bike() {
		super();
	}

	private String data;

	protected void msg() {
		System.err.println("message");
	}

	void run() {
		System.err.println("bike");
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
