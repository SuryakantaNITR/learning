package com.learning.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	Semaphore semaphore = null;
	
	public SemaphoreDemo(int noPermits) {
		semaphore = new Semaphore(noPermits);
	}
	
	public class Print implements Runnable {
		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " acquiring");
				semaphore.acquire();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " working...");
			semaphore.release();
		}
	}
	
	public static void main(String[] args) {
		SemaphoreDemo s = new SemaphoreDemo(10);
		for(int i=1;i<=30;i++)
			new Thread(s.new Print()).start();
		
	}
}
