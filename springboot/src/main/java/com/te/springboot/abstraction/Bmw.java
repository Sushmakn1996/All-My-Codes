package com.te.springboot.abstraction;

public interface Bmw {
	
public static final String S="Sushma";
	
	public static void main(String[] args) {
		System.out.println(S.toUpperCase());
	}	
	
	public default Bmw m1() {
		System.out.println("Bmw default method");
		return null;
	}
	
	public static Bmw m2() {
		System.out.println("Bmw static method");
		return null;
	}

}
