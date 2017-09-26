package com.learning.paradigms.dp;

public class LongestPallindromicSubsequence {
	public static int lps(String seq) {
		int n = seq.length();
		int i, j, l;
		
		int[][] cache = new int[n][n];
		
		for(i=0;i<n;i++)
			cache[i][i]=1;
		
		for(l=2;l<=n;l++) {
			for(i=0;i<n-l+1;i++) {
				j = i+l-1;
				
				if(seq.charAt(i) == seq.charAt(j) && l == 2)
					cache[i][j] = 2;
				
				else if(seq.charAt(i) == seq.charAt(j))
					cache[i][j] = 2+cache[i+1][j-1];
				
				else
					cache[i][j] = Math.max(cache[i+1][j], cache[i][j-1]);
			}
		}
		return cache[0][n-1];
	}
	public static void main(String[] args) {
		String seq = "GEEKSFORGEEKS";
        System.out.println("The length of the lps is "+ lps(seq));
	}
}
