package com.learning.ds;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapImplementation {
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
	
	public HeapImplementation() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 15, 10, 20, 3};
		HeapImplementation h = new HeapImplementation();
		for(int i=0;i<arr.length;i++) {
			h.minHeap.add(arr[i]);
			h.maxHeap.add(arr[i]);
		}
		
		System.out.println("Min heap ");
		h.minHeap.forEach(i -> System.out.print(i + " "));
		
		System.out.println(" ");
		System.out.println("Max heap ");
		h.maxHeap.forEach(i -> System.out.print(i + " "));
		
		System.out.println(" ");
		System.out.println("After removing individual elements");
		for(int i=0;i<arr.length;i++) {
			System.out.println("Min heap ");
			h.minHeap.poll();
			h.minHeap.forEach(j -> System.out.print(j + " "));
			
			System.out.println(" ");
			System.out.println("Max heap ");
			h.maxHeap.poll();
			h.maxHeap.forEach(j -> System.out.print(j + " "));
			double median = 1.0;
			System.out.println("median:" + String.valueOf(median));
			
		}
		
	}

}
