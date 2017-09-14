package com.learning.paradigms.dp;

public class CutRod {
	public static int cutRod(int[] a, int length) {
		int[] cache = new int[length+1];
		cache[0]=0;
		
		for(int i=1;i<=length;i++) {
			int max = Integer.MIN_VALUE;
			for(int j=0;j<i;j++) {
				max = Math.max(a[j]+cache[i-1-j], max);
			}
			cache[i]=max;
		}
		return cache[length];
	}

}
