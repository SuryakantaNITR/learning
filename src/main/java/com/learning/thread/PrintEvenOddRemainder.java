package com.learning.thread;

class CoreWorker implements Runnable {
	int max = 20;
	int remainder;
	static Object lock = new Object();
	static int current = 1;
	
	public CoreWorker(int remainder) {
		this.remainder = remainder;
	}
	
	@Override
	public void run() {
		while(current<max) {
			synchronized (lock) {
				while(remainder != current%2) {
					try {
						lock.wait();
					}
					catch(InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
				
				
				System.out.println(Thread.currentThread().getName() + ": " + current++);
				lock.notifyAll();
				}
			}
	}
	
}
public class PrintEvenOddRemainder {
	
	public static void main(String[] args) {
		CoreWorker c1 = new CoreWorker(1);
		CoreWorker c2 = new CoreWorker(0);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
		t1.start();t2.start();
	}

}
