package com.learning.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapByValues {
	
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("America", 3);
		m.put("India", 0);
		m.put("Singapore", 2);
		m.put("Au", 7);
		
		System.out.println(m.toString());
		
		Set<Entry<String, Integer>> s = m.entrySet();
		List<Entry<String, Integer>> l = new ArrayList<Entry<String, Integer>>(s);
		System.out.println(s.toString());
		System.out.println(l.toString());
		Collections.sort(l, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				return (e1.getValue().compareTo(e2.getValue()));
			}
		});
		m.clear();
		System.out.println(l);
		Map<String, Integer>  sortedMap = new LinkedHashMap<String, Integer>();
		for(Entry<String, Integer> e: l) {
			sortedMap.put(e.getKey(), e.getValue());
		}
		System.out.println(sortedMap);
		
		
	}

}
