package com.te.springboot.abstraction;

public class NewBike extends Bike{
	
	public NewBike() {
		super();
	}

	void run() {
		System.err.println("New bike");
		
	}
	
	public static void main(String[] args) {
		Bike bike=new Bike();
		bike.run();
		
		Bike b=new NewBike();
//		String s=b.data;
		b.msg();
		
		NewBike n=(NewBike) b;
		n.run();
		b.run();
		
	}

}
