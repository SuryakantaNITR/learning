package com.learning.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBfs {
	private int V;
	private ArrayList<LinkedList<Integer>> adj;
	
	public GraphBfs(int v) {
		V = v;
		adj = new ArrayList<>();
		for(int i=0;i<V;i++)
			adj.add(new LinkedList<>());
	}
	
	public void addEdge(int v, int w) {
		adj.get(v).add(w);
	}
	
	public void bfs(int s) {
		boolean[] visited = new boolean[V] ;
		Queue<Integer> queue = new LinkedList<>();
		
		visited[s] = true;
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			System.out.println(u + " ");
			
			LinkedList<Integer> list = adj.get(u);
			for(Integer i: list) {
				if(!visited[i]) {
					visited[i]=true;
					queue.add(i);
				}
			}
		}
	}
	private void dfsUtil(int s, boolean[] visited) {
		visited[s] = true;
		System.out.println(s + " ");
		LinkedList<Integer> list = adj.get(s);
		for(Integer i: list) {
			if(!visited[i])
				dfsUtil(i, visited);
		}
			
	}
	
	public void dfs() {
		boolean[] visited = new boolean[V];
		
		for(int i=0;i<V;i++) {
			if(!visited[i])
				dfsUtil(i, visited);
		}
	}
	
	public static void main(String[] args) {
		GraphBfs g = new GraphBfs(4);
		
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.bfs(2);
        
        System.out.println("DFS");
        
        g.dfs();
	}

}
