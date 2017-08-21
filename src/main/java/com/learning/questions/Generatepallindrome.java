package com.learning.questions;

public class Generatepallindrome {
	public static int calculatePallindrome(int n, int isOdd) {
		int pall = n;
		int input = n;
		
		if(isOdd == 1)
			input /= 10; 
		while(input>0) {
			pall = (pall*10) + (input%10);
			input /= 10;
		}
		
		return pall;
	}
	public static void main(String[] args) {
		int n = 102;
		int i, num;
		for(int j=0;j<2;j++) {
			i=1;
			while((num=calculatePallindrome(i, j%2)) < n) {
				System.out.println(num);
				i++;
			}
		}
		
	}
}
