package com.learning.theory;

public class LearnString {
	public static void main(String[] args) {
		String s = "Hello";
		s.concat(" World!");
		System.out.println(s);
		
		StringBuffer sb = new StringBuffer("Hello");
		sb.append(" World!");
		System.out.println(sb);
		
		StringBuilder stringBuilder = new StringBuilder("Hello");
		stringBuilder.append(" World!");
		System.out.println(stringBuilder);
	}

}
