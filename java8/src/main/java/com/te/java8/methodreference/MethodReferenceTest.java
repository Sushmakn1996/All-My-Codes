package com.te.java8.methodreference;

public class MethodReferenceTest {

	public static void main(String[] args) {
		
		MethodReference methodReference=(a,b)-> {
			return a+b;
		};
		System.err.println(methodReference.sum(5, 5));
		
		MethodReference methodReference2=Test::testMethod;
		System.err.println(methodReference2.sum(5, 5));
		
	}
}


 class Test{
	 public static int testMethod(int a,int b) {
		System.out.println("Test Method execution");
		return a+b;
	}
	
}
