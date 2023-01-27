package com.te.java8.functional;

@FunctionalInterface
public interface MyFunctionalInterface {
	
//	void m1();
	
//	int add(int a,int b);
	
	int sub(int a,int b);
	
	
	default void m2() {
		System.err.println("Default method");
	}
	
	static void m3() {
		System.out.println("Static method");
	}

}
