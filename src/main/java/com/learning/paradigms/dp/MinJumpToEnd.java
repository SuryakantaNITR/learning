package com.learning.paradigms.dp;

public class MinJumpToEnd {
	public static int minJumps(int[] arr, int n) {
		int[] jumps = new int[n];
		jumps[0]=0;
		for(int i=1;i<n;i++) {
			jumps[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++) {
				if(i<=j+arr[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j]+1);
					break;
				}
			}
		}
		return jumps[n-1];
	}
	public static void main(String[] args) {
		int arr[] = {1, 3, 6, 1, 0, 9};
        
	    System.out.println("Minimum number of jumps to reach end is : "+
	                                  minJumps(arr,arr.length));
	 
	}

}
