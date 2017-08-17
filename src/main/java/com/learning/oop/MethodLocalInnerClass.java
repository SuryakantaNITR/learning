package com.learning.oop;

class OuterDemo {
	public void createInner() {
		// final variables can be accessed from within Inner class method as inner class object stays in heap and thus can change variable
		// even if method control goes out of scope
		final int x = 1;
		
		// Only abstract or final modifier is permitted in method local inner class
		class Inner {
			void show() {
				System.out.println("Show method in method local inner class");
				System.out.println(x);
			}
		}
		Inner in = new Inner();
		in.show();
	}
	
}
public class MethodLocalInnerClass {

}
