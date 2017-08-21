package com.learning.questions;

public class RainTrappingWater {
	public static int getWaterAmount(int[] arr) {
		int n = arr.length;
		int l=0, h=n-1, result=0, leftMax=0, rightMax=0;
		
		while(l<=h) {
			if(arr[l] <= arr[h]) {
				if(leftMax < arr[l])
					leftMax = arr[l];
				else 
					result += leftMax - arr[l];
				
				l++;
			}
			else {
				if(rightMax < arr[h])
					rightMax = arr[h];
				else
					result += rightMax - arr[h];
				
				h--;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(getWaterAmount(arr));
	}

}
