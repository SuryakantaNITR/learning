package com.learning.theory;

public class Static {

	public static int x =10;
	public int y=12;
	
	public int getX() {
		return Static.x;
	}
	
	public static int geyY() {
		//return y;
		return x;
	}
	
	public static void main(String[] args) {
		Static s = new Static();
		System.out.println(s.getX());
	}
}
