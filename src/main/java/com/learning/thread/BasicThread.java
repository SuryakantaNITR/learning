package com.learning.thread;

import java.lang.Thread;

public class BasicThread extends Thread {

	public void run() {
		System.out.println(Thread.currentThread().getName()+": In Thread.run method");
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+": In main method");
		BasicThread bt = new BasicThread();
		bt.setName("Basic Thread");
		bt.start();
	}
}
