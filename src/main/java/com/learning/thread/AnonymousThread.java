package com.learning.thread;

public class AnonymousThread {
	
	public static void main(String[] args) {
		Thread thread = new Thread("Thread 1") {
			public void run() {
				System.out.println("In thread "+ this.getName());
			}
		};
		thread.setName("thread 1");
		thread.start();
	}

}
