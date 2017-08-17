package com.learning.questions;

public class LongestCommnPrefixString {
	public static String getLcps(String[] strArray) {
		if(strArray == null || strArray.length == 0)
			return "";
		String pre = strArray[0]; int i=1;
		while(i<strArray.length) {
			while(strArray[i].indexOf(pre) != 0) {
				pre = pre.substring(0, pre.length()-1);
			}
			i++;
		}
		return pre;
	}
	public static void main(String[] args) {
		
	}
}
