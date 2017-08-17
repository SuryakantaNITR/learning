package com.learning.theory;

class Outer {
	int x=5;
	static int y=7;
	private int z=9;
	
	class RegularInner {
		int x=2;
		Outer outer = new Outer();
		int getOuterX() {
			return outer.x;
		}
	}
	
	static class StaticInner {
		int getOuterY() {
			return y;
		}
	}
	
	abstract class AbstractInner {
		int getOuterZ() {
			return z;
		}
	}
	
}

public class InnerClass {
	public static void main(String[] args) {
		Outer.RegularInner regInner = new Outer().new RegularInner();
		System.out.println(regInner.getOuterX());
		Outer.StaticInner staticInner = new Outer.StaticInner();
		System.out.println(staticInner.getOuterY());
		Outer.AbstractInner abstractInner = new Outer().new AbstractInner(){
			
		};
		System.out.println(abstractInner.getOuterZ());
				
	}
}
