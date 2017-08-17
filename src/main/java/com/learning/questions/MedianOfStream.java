package com.learning.questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfStream {
	
	PriorityQueue<Double> maxQueueLeft = new PriorityQueue<>();
	PriorityQueue<Double> minQueueRight = new PriorityQueue<>(new Comparator<Double>() {

		@Override
		public int compare(Double o1, Double o2) {
			return o2.intValue() - o1.intValue();
		}
		
	});
	double median = 0;
	
	public double getMedian(double element, double median) {
		if(maxQueueLeft.size() > minQueueRight.size()) {
			if(element < median) {
				double top = maxQueueLeft.poll();
				minQueueRight.add(top);
				maxQueueLeft.add(element);
			}
			else {
				minQueueRight.add(element);
			}
			
			median = ((double)maxQueueLeft.peek() + (double)minQueueRight.peek())/2.0;
		}
		
		else if(maxQueueLeft.size() == minQueueRight.size()) {
			if(element<median) {
				maxQueueLeft.add(element);
				median = maxQueueLeft.peek();
			}
				
			else {
				minQueueRight.add(element);
				median = minQueueRight.peek();
			}
		}
		
		else {
			if(element > median) {
				double top = minQueueRight.poll();
				maxQueueLeft.add(top);
				minQueueRight.add(element);
			}
			else {
				maxQueueLeft.add(element);
			}
			median = ((double)maxQueueLeft.peek() + (double)minQueueRight.peek())/2.0;
		}
		
		return median;
	}
	
	public static void main(String[] args) {
		double[] arr = {5, 15, 10, 20, 3};
		MedianOfStream m = new MedianOfStream();
		for(int i=0;i<arr.length;i++) {
			System.out.println(m.getMedian(arr[i], m.median));
		}
		
	}
}
