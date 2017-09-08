package com.learning.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	CountDownLatch countDownLatch = null;
	
	public CountDownLatchDemo(int count) {
		// TODO Auto-generated constructor stub
		countDownLatch = new CountDownLatch(count);
	}
	
	class Waiter implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Waiter released");
		}
		
	}
	
	class Decrementer implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(3000);
				countDownLatch.countDown();
				System.out.println("reduced count");
				
				Thread.sleep(3000);
				countDownLatch.countDown();
				System.out.println("reduced count");
				
				Thread.sleep(3000);
				countDownLatch.countDown();
				System.out.println("reduced count");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo(3);
		
		Waiter waiter = countDownLatchDemo.new Waiter();
		Decrementer decrementer = countDownLatchDemo.new Decrementer();
		
		new Thread(waiter).start();
		new Thread(decrementer).start();
		
		Thread.sleep(2000);
	}
}
