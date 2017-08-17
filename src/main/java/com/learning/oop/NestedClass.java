package com.learning.oop;

class Outer {
	// Simple Nested Inner Class
	class Inner {
		public void show() {
			System.out.println("In inner.show() ");
		}
		
		// Static inner method in not possible here as method is associated with an object of outer class
//		public static void showStatic() {
//			
//		}
	}
	
	static class StaticInner {
		public static void show() {
			
		}
	}
}
public class NestedClass {
	public static void main(String[] args) {
		Outer.Inner in = new Outer().new Inner();
		in.show();
	}
}
