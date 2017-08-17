package com.learning.sort;

public class MergeSort {
	public void merge(int[] a, int l, int m, int h) {
		int n1 = m-l+1;
		int n2 = h-m;
		int[] a1 = new int[n1];
		int[] a2 = new int[n2];
		
		for(int i=0;i<n1;i++)
			a1[i]=a[i+l];
		
		for(int i=0;i<n2;i++)
			a2[i]=a[m+i+1];
		
		int j=0, k=0;
		int p=l;
		while(j<n1 && k<n2) {
			if(a1[j]<a2[k]) {
				a[p] = a1[j];
				j++;
			}
			else {
				a[p] = a2[k];
				k++;
			}
			p++;
		}
		
		while(j<n1) {
			a[p] = a1[j];
			j++; p++;
		}
		
		while(k<n2) {
			a[p] = a2[k];
			k++; p++;
		}
	}
	public void sort(int[] a, int l, int h) {
		if(l<h) {
			int mid = (l+h)/2;
			
			sort(a, l, mid);
			sort(a, mid+1, h);
			merge(a, l, mid, h);
		}
	}
	public static void printArray(int[] a) {
		for(int i=0;i<a.length;i++ ) {
			System.out.print(a[i]+" ");
		}
	}
	public void iterateMergeSort(int[] a) {
		int len = a.length;
		int lIndex = 0, currentSize=0;
		
		for(currentSize=1;currentSize<=len-1;currentSize *= 2) {
			for(lIndex=0;lIndex<len-1;lIndex += 2*currentSize) {
				int mid = lIndex+currentSize -1;
				int right = Math.min(lIndex + 2*currentSize -1 , len-1);
				merge(a, lIndex, mid, right);
			}
		}
		
	}
	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};
		 
        System.out.println("Given Array");
        printArray(arr);
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        printArray(arr);
        
        ob.iterateMergeSort(arr);
        
        System.out.println("\nSorted array");
        printArray(arr);
	}

}
