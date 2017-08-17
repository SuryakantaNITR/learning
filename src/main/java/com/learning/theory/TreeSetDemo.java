package com.learning.theory;

import java.util.HashMap;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet<Integer> times = new TreeSet<Integer>();
		times.add(1205);
		times.add(1505);
		times.add(1545);
		times.add(1830);
		times.add(2010);
		times.add(2100);
		
		TreeSet<Integer> sub1 = new TreeSet<Integer>();
		sub1 = (TreeSet<Integer>) times.headSet(1600);
		System.out.println(sub1.toString());
		System.out.println(sub1.last());
		
		
		TreeSet<Integer> sub2 = new TreeSet<Integer>();
		sub2 = (TreeSet<Integer>) times.tailSet(1600);
		System.out.println(sub2.toString());
		System.out.println(sub2.first());
		
		System.out.println(times.lower(1600));
		System.out.println(times.higher(1600));
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
	}

}
