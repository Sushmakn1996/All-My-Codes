package com.te.springboot.garbage;

public class TestGarbage {
	public void finalize() {
		System.err.println("garbage collected");
		
	}
	
	
	public static void main(String[] args) {
		new TestGarbage();
		new TestGarbage();
		new TestGarbage();
		System.gc();
	}
	

}
