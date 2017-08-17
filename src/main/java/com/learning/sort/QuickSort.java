package com.learning.sort;

public class QuickSort {
	
	public static int getPivot(int[] a, int low, int high) {
		int p = high;
		int i = low-1;
		
		for(int j=low;j<high;j++) {
			if(a[j]<=a[p]) {
				i++;
				
				int temp = a[j];
				a[j]=a[i];
				a[i]=temp;
			}
		}
		int temp = a[i+1];
		a[i+1] = a[p];
		a[p]=temp;
		return i+1;
	}
	public void sort(int[] a, int l, int h) {
		if(l<h) {
			int p = getPivot(a, l, h);
			sort(a, l, p-1);
			sort(a, p+1, h);
			
		}
	}
	
	public static void printArray(int[] a) {
		for(int i: a) {
			System.out.print(i);
		}
	}
	public static void main(String[] args) {
		int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
 
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);
 
        System.out.println("sorted array");
        printArray(arr);
	}

}
