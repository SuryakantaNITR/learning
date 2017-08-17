package com.learning.theory;

interface Bounceable {
	
}

interface Moveable extends Bounceable{
	
}

interface ElectronicProduct {
	public void getName();
}

class Mobile implements ElectronicProduct {
	public void getName() {
		System.out.println("Name is Apple");
	}
	Mobile() {
		
	}
}

class Samsung extends Mobile implements ElectronicProduct {
	int x;
	Samsung(){
		super();
		this.x=5;
	}
	
}

public class MultilevelInheritance {
	static int x;
	public static void main(String[] args) {
		System.out.println(x);
	}
}
