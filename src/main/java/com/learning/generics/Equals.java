package com.learning.generics;

class Car extends Object{
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
		
	public boolean equals(Car c) {
		return this.price == c.price;
	}
}
public class Equals {
	public static void main(String[] args) {
		Car maruti = new Car();
		maruti.setPrice(123);
		Car honda = new Car();
		honda.setPrice(123);
		Car nissan = maruti;
		nissan.setPrice(1234);
		
		System.out.println("Hash: Maruti, "+maruti.hashCode()+"; Honda, "+honda.hashCode());
		System.out.println("Hash: Maruti, "+maruti.hashCode()+"; Nissan, "+nissan.hashCode());
		
		System.out.println(maruti.equals(honda));
		System.out.println(maruti == honda);
		
		System.out.println("Price: "+"Maruti, "+maruti.getPrice()+"; nissan: "+nissan.getPrice());
		
		System.out.println(maruti.equals(nissan));
		System.out.println(maruti == nissan);
	}
}
