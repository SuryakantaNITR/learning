package com.learning.paradigms.dp;

public class SubsetSum {
	public static boolean isSubsetSum(int[] set, int n, int sum) {
		boolean[][] cache = new boolean[n+1][sum+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=sum;j++) {
				if(j==0)
					cache[i][j]=true;
				else if(i==0 && j!=0)
					cache[i][j]=false;
				
				else if(j<set[i-1])
					cache[i][j] = cache[i-1][j];
				else
					cache[i][j] = cache[i-1][j] || cache[i-1][j-set[i-1]];
			}
		}
		return cache[n][sum];
	}
	public static void main(String[] args) {
		int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 13;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
           System.out.println("Found a subset with given sum");
        else
           System.out.println("No subset with given sum");
	}

}
