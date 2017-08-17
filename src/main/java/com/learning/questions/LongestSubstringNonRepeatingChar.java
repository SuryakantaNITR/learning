package com.learning.questions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNonRepeatingChar {
	public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int[] ref = new int[s.length()];
        
        for(int i=0;i<s.length();i++) {
        	if(m.get(s.charAt(i)) == null)
        		m.put(s.charAt(i), 0);
            m.put(s.charAt(i), m.get(s.charAt(i))+1);
            ref[i] = m.get(s.charAt(i));
        }
        
        int fin_len=0, curr_len_1=0, curr_len_2=0;
        for(int i=0;i<ref.length;i++) {
            if(ref[i] == 2) {
                if(curr_len_2 == 0 && curr_len_1 == 0) {
                    curr_len_2++;
                    curr_len_1++;
                }
                else {
                    curr_len_2=0;
                    curr_len_1=0;           
                }
            }
            else if(ref[i] == 1) {
                curr_len_2++;
                curr_len_1++;
            }
            else {
                curr_len_2=0;
                curr_len_1=0;
            }
            fin_len = fin_len>curr_len_1 ? (fin_len > curr_len_2 ? fin_len : curr_len_2):(curr_len_1>curr_len_2 ? curr_len_1 : curr_len_2);
            
        }
        return fin_len;
    }
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
