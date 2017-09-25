package com.learning.paradigms.dp;

public class LongestSubstringNonrepeatigChar {
	public static int longestUniqueSubsttr(String str) {
		int len = str.length();
		int cur_len = 1,  max_len = 1;
		int[] visited = new int[256];
		int prev_index;
		
		for(int i=0;i<256;i++)
			visited[i] = -1;
		visited[str.charAt(0)] = 0;
		
		for(int i=1;i<len;i++) {
			prev_index = visited[str.charAt(i)];
			
			if(visited[str.charAt(i)] != -1 && i-cur_len > prev_index)
				cur_len++;
			
			else {
				max_len = Math.max(cur_len, max_len);
				cur_len = i-prev_index;
			}
			visited[str.charAt(i)] = i;
		}
		return Math.max(cur_len, max_len);
	}
	public static void main(String[] args) {
		String str = "ABDEFGABEF";
        System.out.println("The input string is "+str);
        int len = longestUniqueSubsttr(str);
        System.out.println("The length of "
                + "the longest non repeating character is "+len);
	}

}
