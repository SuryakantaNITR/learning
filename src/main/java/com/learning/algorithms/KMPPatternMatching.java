package com.learning.algorithms;

public class KMPPatternMatching {
	public static int[] createPrefixArray(String pattern) {
		int n = pattern.length();
		int[] p = new int[n];
		int j=1, i=0;
		p[0]=0;
		while(j<n) {
			if(pattern.charAt(j) == pattern.charAt(i)) {
				p[j]=i+1;
				i++;
				j++;
			}
			else {
				if(i != 0)
					i = p[i-1];
				else {
					p[j]=0;
					j++;
				}
					
			}
		}
		return p;
	}
	public static boolean matchPattern(String pattern, String text) {
		int[] prefixArray = createPrefixArray(pattern);
		int i=0, j=0;
		for(i=0, j=0;i<text.length();) {
			if(text.charAt(i) == pattern.charAt(j)) {
				i++; j++;
			}
			else {
				if(j!=0) {
					j = prefixArray[j-1];
				}
				else 
					i++;
			}
				
		}
		if(j == pattern.length())
			return true;
		return false;
	}
	public static void main(String[] args) {
		String pattern = "abcaby", text = "abxabcabcaby";
		System.out.println(matchPattern(pattern, text));
	}
}
