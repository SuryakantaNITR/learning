package com.learning.theory;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapVsSubMap {
	public static void main(String[] args) {
		TreeMap<String, String> m = new TreeMap<String, String>();
		m.put("a", "ant");
		m.put("c", "cat");
		m.put("f", "fish");
		m.put("b", "bat");
		System.out.println(m);
		
		SortedMap<String, String> submap;
		submap = m.subMap("b", "g"); 
	}

}
