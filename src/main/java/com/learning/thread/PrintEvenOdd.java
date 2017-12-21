package com.learning.thread;


public class PrintEvenOdd {
	boolean isOdd;
	int i = 1, max = 20;
	
	public synchronized void printOdd() {
		while(i<=max) {
			while(!isOdd) {
				try {
					wait();
				}
				catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println(Thread.currentThread().getName() + ": " + i++);
			isOdd = false;
			notifyAll();
		}
	}
	
	public synchronized void printEven() {
//		try {
//			Thread.sleep(1000);
//		}
//		catch(InterruptedException e) {
//			System.out.println(e.getMessage());
//		}
		
		while(i<=max) {
			while(isOdd) {
				try {
					wait();
				}
				catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println(Thread.currentThread().getName() + ": " + i++);
			isOdd = true;
			notifyAll();
		}
	}
	
	public static void main(String[] args) {
		PrintEvenOdd obj = new PrintEvenOdd();
		obj.isOdd = true;
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				obj.printOdd();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				obj.printEven();
			}
		});
		
		t1.start();
		t2.start();
	}
}
