package com.learning.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	CyclicBarrier cyclicBarrier = null;
	
	public CyclicBarrierDemo(int count) {
		cyclicBarrier = new CyclicBarrier(count, new BarrierAction());
	}
	
	class BarrierAction implements Runnable {
		@Override
		public void run() {
			System.out.println("Completed barrier!");
		}
	}
	class Worker implements Runnable {
		
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
				System.out.println("Worker thread: " + Thread.currentThread().getName() + " Waiting for barrier.");
				cyclicBarrier.await();
				System.out.println("Thread: " + Thread.currentThread().getName() + " Done! ");
				
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo(3);
		Worker worker = cyclicBarrierDemo.new Worker();
		new Thread(worker).start();
		new Thread(worker).start();
		new Thread(worker).start();
	}
}
