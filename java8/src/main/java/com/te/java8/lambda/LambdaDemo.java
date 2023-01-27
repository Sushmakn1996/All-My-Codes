package com.te.java8.lambda;

public class LambdaDemo {

	public static void main(String[] args) {
		LambdaInterface interface1 = new LambdaInterface() {

			@Override
			public void m1() {
				System.out.println("hii");
			}
		};
		interface1.m1();
	}

}

//@Override
//public void m1() {
//	System.out.println("m1 method");
//}
//
////(){
////	System.err.println("Anonymous method");
////}
//
//public static void main(String[] args) {
//	new LambdaDemo().m1();
//}