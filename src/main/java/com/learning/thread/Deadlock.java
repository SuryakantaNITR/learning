package com.learning.thread;



public class Deadlock {
	public static Object one = new Object();
	public static Object two = new Object();
	
	class DemoOne implements Runnable{
		public void run() {
			System.out.println(Thread.currentThread().getName()+": Blocking DemoOne object");
			synchronized(one) {
				System.out.println(Thread.currentThread().getName()+": Blocked DemoOne object");
				try {
					Thread.sleep(10);
				}
				catch(InterruptedException ex) {
					
				}
				System.out.println(Thread.currentThread().getName()+": Blocking DemoTwo object");
				synchronized(two) {
					System.out.println(Thread.currentThread().getName()+": Blocked DemoTwo object");
				}
			}
		}
	}

	class DemoTwo implements Runnable {
		public void run() {
			System.out.println(Thread.currentThread().getName()+": Blocking DemoTwo object");
			synchronized(two) {
				System.out.println(Thread.currentThread().getName()+": Blocked DemoTwo object");
				try {
					Thread.sleep(10);
				}
				catch(InterruptedException ex) {
					
				}
				System.out.println(Thread.currentThread().getName()+": Blocking DemoOne object");
				synchronized(one) {
					System.out.println(Thread.currentThread().getName()+": Blocked DemoOne object");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Deadlock d = new Deadlock();
		DemoOne d1 = d.new DemoOne();
		DemoTwo d2 = d.new DemoTwo();
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);
		t1.start();
		t2.start();
	}

}
