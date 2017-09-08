package com.learning.concurrency;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLockReentrance {
	
	private int writers = 0;
	private int writerRequests = 0;
	private Map<Thread, Integer> readerCount = new HashMap<>();
	
	private int writerAccess = 0;
	private Thread writerThread = null;
	
	public synchronized void readerLock() throws InterruptedException {
		while(!isLockAllowedForReader()) {
			wait();
		}
		readerCount.put(Thread.currentThread(), getReaderCount()+1);
	}
	
	public synchronized void readerUnlock() {
		if(readerCount.get(Thread.currentThread()) == 1)
			readerCount.put(Thread.currentThread(), 0);
		
		else
			readerCount.put(Thread.currentThread(), readerCount.get(Thread.currentThread())-1);
		
		notifyAll();
	}
	
	private boolean isLockAllowedForReader() {
		if(writers>0) return false;
		if(readerCount.get(Thread.currentThread())!=null) return true;
		if(writerRequests>0) return false;
		
		return true;
	}
	
	public Integer getReaderCount() {
		if(readerCount.get(Thread.currentThread()) == null) return 0;
		else return readerCount.get(Thread.currentThread());
	}
	
	public synchronized void writerLock() throws InterruptedException {
		writerRequests++;
		while(!isLockAllowedForWriter()) {
			wait();
		}
		writerRequests--;
		writerAccess++;
		writerThread = Thread.currentThread();
	}
	
	public synchronized void writerUnlock() {
		writerAccess--;
		if(writerAccess == 0) writerThread = null;
		notifyAll();
	}
	
	public boolean isLockAllowedForWriter() {
		if(readerCount.size() > 0) return false;
		if(writerThread == null) return true;
		if(writerThread == Thread.currentThread()) return true;
		return true;
	}

}
