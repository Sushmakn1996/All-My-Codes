package com.te.java8.constructorchaining;

class Bus {
	Bus() {
		this("Banglore"); // this(“Banglore”) will call Bus(String name)
		System.out.println("Bus is empty.....!");
	}

	Bus(String name) {
		this(10); // this(10) will call Bus(int num)
		System.out.println("Bus is having a name.....!");
	}

	Bus(int num) {
		System.out.println("Bus is having a NUMBER.....!");
	}
}


