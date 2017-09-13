package com.learning.paradigms.dp;

public class BinomialCoefficient {

	public static int calculateCoefficient(int n, int k) {		
		int[][] cache = new int[n+1][k+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=Math.min(i, k);j++) {
				if(i==0 || j==0)
					cache[i][j]=1;
				else
					cache[i][j] = cache[i-1][j-1] + cache[i-1][j];
			}
				
		}
		return cache[n][k];
	}
	public static void main(String[] args) {
		int n = 5, k = 2;
		System.out.println(calculateCoefficient(n, k));
	}
}
