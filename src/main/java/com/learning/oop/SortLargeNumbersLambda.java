package com.learning.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SortLargeNumbersLambda {
	
	public static void main(String[] args) {
		String arr[] = {"5", "1237637463746732323",
                "97987", "12" };
		
		Arrays.sort(arr, (left, right) -> {
			if(left.length() != right.length())
				return left.length() - right.length();
			return left.compareTo(right);
				
		}
		
			
		);
		
		for(String str : arr) {
			System.out.println(str);
		}
	}
	List<Integer> list = new ArrayList<Integer>();

}
