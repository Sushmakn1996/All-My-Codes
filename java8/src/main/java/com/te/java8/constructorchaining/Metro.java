package com.te.java8.constructorchaining;

public class Metro extends Train {

	Metro() {
		this("RAMAGIRI");// this(“RAMAGIRI”) will call Bus(String name)
		System.out.println("Bus is empty.....!");
	}

	Metro(String name) {
		this(10); // this(10) will call Bus(int num)
		System.out.println("Bus is having a name.....!");
	}

	Metro(int num) {
		super();// super() will call Train() because Train is parent class
		System.out.println("Bus is having a NUMBER.....!");
	}

	public static void main(String[] args) {
		new Metro();
	}
}