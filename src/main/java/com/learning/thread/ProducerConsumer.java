package com.learning.thread;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
	static final int QUEUE_SIZE = 10;
	
	public static Queue<Date> queue = new LinkedList<Date>();
	
	public class Producer implements Runnable {
		public void run() {
			while(true) {
				synchronized (queue) {
					while(queue.size() == QUEUE_SIZE) {
						try {
							queue.wait();
						}
						catch(InterruptedException ex) {
							
						}
					}
					queue.add(new Date());
//					try { Thread.sleep(1000);}
//					catch(InterruptedException ex){}
					queue.notify();
				}
			}
		}
	}
	
	public class Consumer implements Runnable {
		public void run() {
			while(true) {
				synchronized (queue) {
					while(queue.isEmpty()) {
						try {
							queue.wait();
						}
						catch(InterruptedException ex) {
							
						}
					}
					System.out.println("Consumer: " + queue.remove());
					queue.notify();
//					try { Thread.sleep(1000);}
//					catch(InterruptedException ex){}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();
		Producer p = pc.new Producer();
		Consumer c = pc.new Consumer();
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}

}
