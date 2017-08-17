package com.learning.algorithms;

public class FindKthLargest {
	public static void maxHeapify(int[] a, int i, int len) {
		int l = 2*i + 1;
		int r = 2*i + 2;
		int max;
		if(l<len && a[l]>a[i])
			max = l;
		else
			max = i;
		if(r<len && a[r]>a[max])
			max = r;
		
        if(max!=i)
        {
            int temp=a[i];
            a[i]=a[max];
            a[max]=temp;
            maxHeapify(a,max,len);
        }
		
	}
	public static void buildHeap(int[] a) {
		int len = a.length;
		for(int i=len/2-1;i>=0;i--) {
			maxHeapify(a, i, len);
		}
	}
	public static void findKthLargest(int[] a) {
		buildHeap(a);
//		for(int i=0;i<a.length;i++)
//			System.out.println(a[i]);
		System.out.println(a[0]);
		a[0] = Integer.MIN_VALUE;
		buildHeap(a);
		System.out.println(a[0]);
	}
	public static void main(String[] args) {
		int[] arr = {3,2,1,5,6,4};
		findKthLargest(arr);
	}

}
