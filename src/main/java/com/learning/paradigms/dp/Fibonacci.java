package com.learning.paradigms.dp;

public class Fibonacci {
	static int[] bottomUpCache;
	
	public static int topDownApproach(int n) {
		int[] cache = new int[n+1];
		cache[0]=0; cache[1]=1;
		for(int i=2;i<=n;i++)
			cache[i]=cache[i-1]+cache[i-2];
		return cache[n];
	}
	public static int bottomUpApproach(int n) {
		if(bottomUpCache[n]!=-1)
			return bottomUpCache[n];
		if(n<=1)
			bottomUpCache[n] = n;
		else
			bottomUpCache[n] = bottomUpApproach(n-1)+bottomUpApproach(n-2);
		return bottomUpCache[n];
	}
	public static void main(String[] args) {
		int n = 9;
		System.out.println(topDownApproach(n));
		bottomUpCache = new int[n+1];
		for(int i=0;i<=n;i++)
			bottomUpCache[i]=-1;
		System.out.println(bottomUpApproach(n));
	}

}
