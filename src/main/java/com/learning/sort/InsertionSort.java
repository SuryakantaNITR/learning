package com.learning.sort;

public class InsertionSort {
	public void isort(int[] a) {
		int len = a.length;
		for(int i=1;i<len;i++) {
			int element = a[i];
			int j=i-1;
			while(j>=0 && a[j]>element) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1]=element;
		}
	}
	public static void printArray(int[] a) {
		for(int i: a)
			System.out.print(i+" ");
	}
	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6}; 
        InsertionSort ob = new InsertionSort();        
        ob.isort(arr);
        printArray(arr);
	}

}
