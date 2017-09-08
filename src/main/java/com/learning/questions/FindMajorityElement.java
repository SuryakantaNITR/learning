package com.learning.questions;

import java.util.Arrays;

/*
 * Majority element is that which occurs more than n/2 times in an array
 */
public class FindMajorityElement {
	public static void mergeSort(int[] arr, int l, int h) {
		if(l<h) {
			int mid = (l+h)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, h);
			merge(arr, l, mid, h);
		}
		
	}
	
	public static void merge(int[] arr, int l, int m, int h) {
		int l1 = m-l+1, l2=h-m;
		
		
		int[] left = new int[l1];
		int[] right = new int[l2];
		
		int i=0, j=0;
		for(;i<l1;i++)
			left[i] = arr[i+l];
		
		for(;j<l2;j++)
			right[j] = arr[j+m+1];
		
		
		while(i<l1 && j< l2) {
			
		}
		
	}
	
	// Moore's voting algorithm O(N) time
	public static int getMajority(int[] arr) {
		int majority = 0, count=1;
		
		for(int i=1;i<arr.length;i++) {
			if(arr[majority] == arr[i]) {
				count++;
			}
			else {
				count--;
			}
			
			if(count == 0) {
				majority = i;
				count = 1;
			}
		}
		return arr[majority];
	}
	// log(N) method using sorting
	public static int getMajorityBySort(int[] arr) {
//		Arrays.sort(arr);
		mergeSort(arr,0, arr.length-1);
		return arr[arr.length/2];
	}
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 2, 2, 2, 3, 1};
		System.out.println(getMajorityBySort(arr));
	}

}
