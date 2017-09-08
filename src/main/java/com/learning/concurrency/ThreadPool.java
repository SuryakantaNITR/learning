package com.learning.concurrency;

import java.util.List;

public class ThreadPool {
	private BlockingQueue<Runnable> queue = null;
	private boolean isStopped = false;
	private List<PoolThread> workerThreadList = null;
	
	public ThreadPool(int noOfWorkerThreads, int maxQueueLimit) {
		this.queue = new BlockingQueue<>(maxQueueLimit);
		
		for(int i=0;i<noOfWorkerThreads;i++)
			workerThreadList.add(new PoolThread(queue));
		
		for(PoolThread thread: workerThreadList) {
			thread.start();
		}
	}
	
	public synchronized void stop() {
		isStopped = true;
		for(PoolThread thread: workerThreadList)
			thread.doStop();
	}
	
	public synchronized void execute(Runnable task) throws Exception {
		if(this.isStopped)
			throw new IllegalStateException();
		queue.enqueue(task);
	}
	
}

class PoolThread extends Thread {
	private BlockingQueue<Runnable> queue = null;
	private boolean isStopped = false;
	
	public PoolThread(BlockingQueue<Runnable> q) {
		this.queue = q;
	}
	
	@Override
	public void run() {
		while(!isStopped) {
			try {
				Runnable r = (Runnable)queue.dequeue();
				r.run();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public synchronized void doStop() {
		isStopped = true;
		this.interrupt();
	}
	
	public synchronized boolean isStopped() {
		return isStopped;
	}
}
