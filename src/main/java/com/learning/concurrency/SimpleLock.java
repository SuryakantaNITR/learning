package com.learning.concurrency;

public class SimpleLock {
	
	private boolean isLocked = false;
	private Thread lockedBy = null;
	private int count = 0;
	
	public synchronized void lock() throws InterruptedException{
		while(isLocked && lockedBy != Thread.currentThread()) {
			wait();
		}
		isLocked = true;
		lockedBy = Thread.currentThread();
		count++;
	}
	
	public synchronized void unlock() {
		if(lockedBy == Thread.currentThread())
			count--;
		
		if(count == 0) {
			isLocked = false;
			notify();
		}
	}
}
