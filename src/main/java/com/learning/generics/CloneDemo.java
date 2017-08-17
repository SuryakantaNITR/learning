package com.learning.generics;

class Vehicle implements Cloneable{
	int price;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	Vehicle() {}
	
	public Vehicle clone() throws CloneNotSupportedException{
		Vehicle v = new Vehicle();
		v.setPrice(12);
		return v;
	}
	
}
public class CloneDemo {
	public static void main(String[] args) {
		Vehicle twoWheeler = new Vehicle();
		twoWheeler.setPrice(1);
		Vehicle fourWheeler = new Vehicle();
		fourWheeler.setPrice(2);
		
		try { 
			Vehicle newTwoWheeler = (Vehicle)twoWheeler.clone(); 
			System.out.println(newTwoWheeler.hashCode());
			System.out.println(newTwoWheeler.getPrice());
			newTwoWheeler.setPrice(3);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		System.out.println(twoWheeler.hashCode());
		System.out.println(fourWheeler.hashCode());
		
	}
}
