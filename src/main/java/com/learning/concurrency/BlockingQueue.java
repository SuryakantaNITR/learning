package com.learning.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
	private int limit = 0;
	private Queue<T> queue = new LinkedList<>();
	
	public BlockingQueue(int upperLimit) {
		this.limit = upperLimit;
	}
	public synchronized void enqueue(T data) throws InterruptedException{
		while(this.queue.size() == this.limit)
			wait();
		
		while(this.queue.size() == 0)
			notifyAll();
		
		this.queue.add(data);
	}
	
	public synchronized T dequeue() throws InterruptedException {
		while(this.queue.size() == 0)
			wait();
		
		while(this.queue.size() == this.limit)
			notifyAll();
		
		return this.queue.remove();
	}

}
