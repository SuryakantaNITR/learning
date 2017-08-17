package com.learning.generics;

import java.util.ArrayList;
import java.util.List;

class Animal {
	public void getType() {
		System.out.println("Animal Type");
	}
}

class Dog extends Animal{
	public void getType() {
		System.out.println("Dog Type");
	}
}

class Cat extends Animal{
	public void getType() {
		System.out.println("Cat Type");
	}
}

class Horse extends Animal{
	public void getType() {
		System.out.println("Horse Type");
	}
}

class TestGenericClass<T> {
	T printElement(T t) {
		System.out.println(t);
		return t;
	}
}

class TestGenericClass2<T, X> {
	T printElement(T t) {
		System.out.println(t);
		return t;
	}
	
	X printElement(T t, X x) {
		System.out.println(x);
		return x;
	}
}

public class GenericMethods {
	
	public void testAnimals(List<Animal> animalList) {
		animalList.add(new Dog());
	}
	
	public void testGenericAnimals(List<?  extends Animal> animalList) {
		
	}
	
	public <T> void makeArrayList(T t) {
		
	}
	
    public <T extends Number> void makeNumbersArrayList(T t) {
		
	}
	public static void main(String[] args) {
		List<Animal> list = new ArrayList<Animal>();
		list.add(new Dog());
		list.add(new Cat());
		list.add(new Horse());
		
		List<Dog> dogList = new ArrayList<Dog>();
		dogList.add(new Dog());
		dogList.add(new Dog());
		dogList.add(new Dog());
		
		GenericMethods gm = new GenericMethods();
		gm.testAnimals(list);
		gm.testGenericAnimals(dogList);
		
	}

}
