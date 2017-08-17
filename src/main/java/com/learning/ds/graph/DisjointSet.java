package com.learning.ds.graph;

import java.util.HashMap;
import java.util.Map;


public class DisjointSet {
	
	Map<Long, Node> map = new HashMap<>();
	
	class Node {
		long data;
		Node parent;
		int rank;
		
		public Node(long d) {
			data = d;
			rank = 0;
			parent = null;
		}
	}
	
	public void makeSet(long data) {
		Node newNode = new Node(data);
		newNode.parent = newNode;
		map.put(data, newNode); 
	}
	
	public long findSet(long data) {
		return findSet(map.get(data)).data;
	}
	
	public Node findSet(Node node) {
		Node parent = node.parent;
		if(parent == node)
			return parent;
		
		node.parent = findSet(node.parent);
		return node.parent;
	}
	
	public boolean union(long data1, long data2) {
		Node first = map.get(data1);
		Node second = map.get(data2);
		
		Node parent1 = findSet(first);
		Node parent2 = findSet(second);
		
		if(parent1 == parent2)
			return false;
		
		if(parent1.rank >= parent2.rank) {
			parent1.rank = (parent1.rank == parent2.rank)?parent1.rank+1:parent1.rank;
			parent2.parent = parent1;
		}
		else {
			parent1.parent = parent2;
		}
		
		return true;
	}
	public static void main(String[] args) {
		 DisjointSet ds = new DisjointSet();
	        ds.makeSet(1);
	        ds.makeSet(2);
	        ds.makeSet(3);
	        ds.makeSet(4);
	        ds.makeSet(5);
	        ds.makeSet(6);
	        ds.makeSet(7);

	        ds.union(1, 2);
	        ds.union(2, 3);
	        ds.union(4, 5);
	        ds.union(6, 7);
	        ds.union(5, 6);
	        ds.union(3, 7);

	        System.out.println(ds.findSet(1));
	        System.out.println(ds.findSet(2));
	        System.out.println(ds.findSet(3));
	        System.out.println(ds.findSet(4));
	        System.out.println(ds.findSet(5));
	        System.out.println(ds.findSet(6));
	        System.out.println(ds.findSet(7));
	}
}
