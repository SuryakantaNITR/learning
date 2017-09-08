package com.learning.concurrency;

public class ReadWriteLock {

	private int writeRequests = 0;
	private int readers = 0;
	private int writers = 0;
	
	public synchronized void writeLock() throws InterruptedException {
		writeRequests++;
		while(readers > 0 || writers > 0) {
			wait();
		}
		writeRequests--;
		writers++;
	}
	
	public synchronized void writeUnlock() {
		writers--;
		notifyAll();
	}
	
	public synchronized void readLock() throws InterruptedException {
		while(writers > 0 || writeRequests > 0) {
			wait();
		}
		readers++;
	}
	
	public synchronized void readUnlock() {
		readers--;
		notifyAll();
	}
}
