package com.learning.theory;


class Halter {
	public void halter() {
		System.out.println("this animal has a halter");
	}
}

class Horse {
	Halter h = new Halter();
	public void getHalter() {
		h.halter();
	}
}

public class HasARelation {
	public static void main(String[] args) {
		Horse horse = new Horse();
		horse.getHalter();
	}

}
