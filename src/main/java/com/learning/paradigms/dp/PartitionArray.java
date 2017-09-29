package com.learning.paradigms.dp;

public class PartitionArray {
	
	public static boolean findPartition(int[] arr, int n) {
		int sum = 0;
		for(int i=0;i<n;i++)
			sum += arr[i];
		
		if(sum%2 != 0)
			return false;
		
		else
			sum = sum/2;
		
		boolean[][] cache = new boolean[sum+1][n+1];
		
		for(int i=0;i<=n;i++)
			cache[0][i] = true;
		for(int i=1;i<=sum;i++)
			cache[i][0] = false;
		
		for(int i=1;i<=sum;i++) {
			for(int j=1;j<=n;j++) {
				cache[i][j] = cache[i][j-1];
				if(arr[j-1] <= i) {
					cache[i][j] = cache[i][j] || cache[i-arr[j-1]][j-1];
				}
			}
		}
		return cache[sum][n];
	}
	public static void main(String[] args) {
		int arr[] = {3, 1, 1, 2, 2, 1};
        int n = arr.length;
        if (findPartition(arr, n) == true)
            System.out.println("Can be divided into two subsets of equal sum");
        else
            System.out.println("Can not be divided into two subsets of equal sum");
	}

}
