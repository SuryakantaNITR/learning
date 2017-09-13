package com.learning.paradigms.dp;

public class LargestSumContiguousSubarray {
	public static int maxSubArraySum(int[] a) {
		int maxSoFar=a[0], maxEndingHere=a[0];
		
		for(int i=1;i<a.length;i++) {
			maxEndingHere = Math.max(a[i], a[i]+maxEndingHere);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
	public static void main(String[] args) {
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                                       maxSubArraySum(a));
	}

}
