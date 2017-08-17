package com.learning.theory;

class Animal {
	public void makeNoise() {
		System.out.println("Make Noise in animal");
	}
}

class Dog extends Animal {
	public void makeNoise() {
		System.out.println("Make noise in Dog");
	}
	
	public void run() {
		System.out.println("Dog is running");
	}
}

public class ReferenceCasting {
public static void main(String[] args) {
	Animal a = new Dog();
	a.makeNoise();
	Dog d = (Dog) a;
	d.run();
}
}
