package com.te.java8.constructorchaining;

class Train {
	Train() {
		this("DURGA"); // this(“DURGA”) will call
		System.out.println("Train is empty.....!");
	}

	Train(String name) {
		this(55); // this(10) will call Train(int num)
		System.out.println("Train is having a name.....!");
	}

	Train(int num) {
		System.out.println("Train is having a NUMBER.....!");
	}

	public static void main(String[] args) {
		new Train();
	}
}
