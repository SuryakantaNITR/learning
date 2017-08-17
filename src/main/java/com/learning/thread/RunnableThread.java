package com.learning.thread;

import java.lang.Thread;


public class RunnableThread implements Runnable{
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Hello! in RunnableThread Before");
		try {
			Thread.sleep(6000);
		}
		catch(Exception ex) {
			
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println("Hello! in RunnableThread After");
	}
	
	public static void main(String[] args) {
		RunnableThread rt = new RunnableThread();
		Thread t1 = new Thread(rt);
		t1.setName("t1");
		Thread t2 = new Thread(rt);
		t2.setName("t2");
		Thread t3 = new Thread(rt);
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();
	}
}
