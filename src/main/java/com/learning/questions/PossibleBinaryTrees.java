package com.learning.questions;

/*
 * Possible no of binary trees with n elements would be
 * (2n)C(n)/(n+1) = (2n!)/(n!)(n!)(n+1) = (2n!)/(n!)(n+1)!  
 */

public class PossibleBinaryTrees {
	public static int getCombinations(int n, int k) {
		int res = 1;
		for(int i=0;i<k;i++) {
			res *= (n-i);
			res /= (i+1);
		}
		return res;
	}
	public static void main(String[] args) {
		int n=4;
		System.out.println(getCombinations(2*n, n)/(n+1));
	}

}
