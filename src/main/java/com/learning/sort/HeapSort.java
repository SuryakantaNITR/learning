package com.learning.sort;

public class HeapSort {
	
	void sort(int[] arr) {
		int n = arr.length;
		for(int i=n/2 - 1;i>=0;i--)
			heapify(arr, n, i);
		
		System.out.println("Heapify");
		for(int a: arr)
			System.out.print(a+" ");
		
		for(int i = n-1;i>=0;i--) {
			int temp = arr[i];
			arr[i]=arr[0];
			arr[0]=temp;	
			
			heapify(arr, i, 0);
			System.out.println(" ");
			for(int a: arr)
				System.out.print(a+" ");
		}
			
	}
	public void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = i*2 + 1;
		int r = i*2 + 2;
		
		if(l<n && arr[l]>arr[largest])
			largest = l;
		if(r<n && arr[r]>arr[largest])
			largest = r;
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest]=temp;
			
			heapify(arr, n, largest);
		}
	}
	public static void printArray(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}
	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
 
        HeapSort ob = new HeapSort();
        ob.sort(arr);
 
        System.out.println(" ");
        System.out.println("Sorted array is");
        printArray(arr);
	}
}
