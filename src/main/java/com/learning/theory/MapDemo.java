package com.learning.theory;

import java.util.HashMap;
import java.util.Map;

class Rabbit {
	String name;
	
	public int hashcode() {
		return name.length();
	}
	
	public boolean equals(Object o) {
		Rabbit t = (Rabbit)o;
//		return this.name.equals(t.name);
		return this.name.length()==t.name.length();
	}
}
public class MapDemo {
	public static void main(String[] args) {
		Map m = new HashMap();
		m.put("Hello", "world");
		m.put(new Rabbit(), "new rabbit");
		Rabbit r = new Rabbit();
		m.put(r, "new rabbit 2");
		m.put("disco", "dance");
		Rabbit r1 = new Rabbit();
		r1.name="rabbit1";
		
		Rabbit r2 = new Rabbit();
		r2.name="rabbit2";
		
		m.put(r1, "Rabbit 1");
		m.put(r2, "Rabbit 2");
		
		System.out.println(m.get(r2));
	}

}
