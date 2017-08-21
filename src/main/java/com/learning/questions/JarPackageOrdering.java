package com.learning.questions;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * @author suryakanta
 * Given a set of packages or jars, 
 * with dependencies over each other. Write code to provide ordering, in which these packages should be compiled.
 * Time: O(V+E)
 * Space: O(V)
 */
public class JarPackageOrdering {
	
	int v;
	LinkedList<Integer>[] adj;
	
	public JarPackageOrdering(int vertexCount) {
		this.v = vertexCount;
		adj = new LinkedList[vertexCount];
		for(int i=0;i<vertexCount;i++)
			adj[i] = new LinkedList<>();
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	public void printUtil(int v, boolean[] visited, Stack<Integer> stack) {
		
		visited[v] = true;
		
		for(Integer vertex: adj[v]) {
			if(!visited[vertex]) {
				printUtil(vertex, visited, stack);
			}
		}
		stack.push(v);
	}
	public void printOrder() {
		boolean[] visited = new boolean[v];
		for(int i=0;i<v;i++)
			visited[i] = false;
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				printUtil(i, visited, stack);
			}
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}
	
	public static void main(String[] args) {
		JarPackageOrdering j = new JarPackageOrdering(8);
		j.addEdge(0, 1);
		j.addEdge(0, 2);
		j.addEdge(1, 4);
		j.addEdge(4, 5);
		j.addEdge(5, 7);
		j.addEdge(1, 3);
		j.addEdge(2, 3);
		j.addEdge(3, 6);
		j.addEdge(6, 7);
		
		j.printOrder();
	}

}
