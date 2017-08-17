package com.learning.thread;

class Utility implements Runnable {
	int x;
	SyncronizedInstanceMethods s;
	
	public Utility(SyncronizedInstanceMethods sim) {
		x = sim.var;
		s=sim;
	}
	public void run() {
		System.out.println(add(1));
	}
	public synchronized int add(int a) {
		s.var+=a;
		return s.var;
	}
}

public class SyncronizedInstanceMethods {
	int var;
	
	public static void main(String[] args) {
		SyncronizedInstanceMethods sim = new SyncronizedInstanceMethods();
		sim.var=5;
		Utility util = new Utility(sim);
		Thread t1 = new Thread(util);
		Thread t2 = new Thread(util);
		t1.start();
		t2.start();
//		try {
//			Thread.sleep(2);
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		System.out.println(util.s.var);
	}
}
