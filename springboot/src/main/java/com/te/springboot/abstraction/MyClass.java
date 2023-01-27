package com.te.springboot.abstraction;

public class MyClass {

	String name= new String("Sushma");
	
	
	public static void main(String[] args) {
		System.out.println(m1());
	}

	@SuppressWarnings("finally")
	public static String m1() {
		try {
			return "a";
		} catch (Exception e) {
			return "b";
		} finally {
			return "c";
		}

	}

}
