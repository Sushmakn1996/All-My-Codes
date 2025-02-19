package com.te.java8.functional;

public class FunctionalDemo implements MyFunctionalInterface,MyInterface {

	public static void main(String[] args) {

//		MyFunctionalInterface functionalInterface = () -> System.err.println("This is lambda expression");
//		functionalInterface.m1();
//
//		MyFunctionalInterface functionalInterface2 = () -> System.err.println("This is default expression");
//		functionalInterface2.m2();// parent class impl will work

//		MyFunctionalInterface functionalInterface = (a, b) -> a + b;
//		System.out.println(functionalInterface.add(5, 8));
		
		MyFunctionalInterface functionalInterface = (a, b) -> {
			if(b<a) {
				throw new ArithmeticException("Error msg");
			} else {
				return b-a;
			}
		};
		System.err.println(functionalInterface.sub(1,15));
		

	}

	@Override
	public int sub(int a, int b) {
		return 0;
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		MyInterface.super.m2();
	}

}
