package com.learning.sort;

public class BubbleSort {
	public void bubbleSort(int[] a) {
		int len = a.length;
		for(int i=0;i<len;i++) {
			for(int j=0;j<len-i-1;j++) {
				if(a[j] > a[j+1]) {
					int temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		
	}
	public void printArray(int[] a) {
		for(int i: a) {
			System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
	}

}
