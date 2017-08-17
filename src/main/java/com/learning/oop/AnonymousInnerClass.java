package com.learning.oop;

class Demo {
	void show() {
		System.out.println("In show method");
	}
}

interface DemoInterface {
	void show();
}

public class AnonymousInnerClass {
	
	//An anonymous class with Demo as base class 
	static Demo object = new Demo() {
		void show() {
			System.out.println("Overridden show method ");
		}
	};
	
	static DemoInterface di = new DemoInterface() {
		
		public void show() {
			System.out.println("Overridden show method in interface");
		}
	};
	
	public static void main(String[] args) {
		object.show();
		di.show();
	}

}
