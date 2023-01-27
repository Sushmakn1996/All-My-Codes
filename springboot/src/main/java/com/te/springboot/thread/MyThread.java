package com.te.springboot.thread;

public class MyThread extends Thread {
	
	@Override
	public void run() {
		super.run();
	}

	public static void main(String[] args) {
		
		System.err.println(Thread.currentThread().getName());
		
		MyThread thread = new MyThread();
		
		MyThread thread2 = new MyThread();
		
		thread.start();
		
		boolean alive = thread.isAlive();
		System.out.println(alive);
		for (int i = 0; i < 10; i++) {
			System.err.println("Thread :"+thread.getName());
		}
		
		for (int i = 0; i < 5; i++) {
			System.err.println("Thread2 :"+thread2.getName());
		
		}
	}


}
