package com.learning.ds.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * @author suryakanta
 * Topological sort for directed acyclic graph using stack and dfs
 * Time complexity: O(V+E)
 * Space complexity: O(V)
 */
public class TopologicalSort {
	int v;
	LinkedList<Integer> adj[];
	
	public TopologicalSort(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		
		for(Integer vertex: adj[v]) {
			if(!visited[vertex]) {
				topologicalSortUtil(vertex, visited, stack);
			}
		}
		stack.push(v);
	}
	public void topologicalSort() {
		boolean[] visited = new boolean[v];
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<v;i++)
			visited[i] = false;
		
		for(int i=0;i<v;i++) {
			if(!visited[i])
				topologicalSortUtil(i, visited, stack);
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
	}
	public static void main(String[] args) {
		TopologicalSort g = new TopologicalSort(6);
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        
        g.topologicalSort();
	}
}
