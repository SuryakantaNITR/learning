package com.learning.thread;

public class ThreadJoin implements Runnable {
	public void run() {
		synchronized (this) {
			for(int i=0;i<10;i++)
				System.out.println(Thread.currentThread().getName()+": "+i);
		}
		
	}
	
	public synchronized static void printCount() { 
	}
	
	public static void main(String[] args) {
		ThreadJoin runnable = new ThreadJoin();
		Thread t1 = new Thread(runnable);
		t1.setName("t1");
		Thread t2 = new Thread(runnable);
		t2.setName("t2");
		t1.start();
		t2.start();
		try {
			t2.join();
		}
		catch(InterruptedException ex) {
			System.out.println(ex);
		}
	}

}
