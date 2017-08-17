package com.learning.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnTopologicalSort {
	int v;
	int[] inDegree;
	LinkedList<Integer>[] adj;
	
	public KahnTopologicalSort(int vertexCount) {
		this.v = vertexCount;
		adj = new LinkedList[vertexCount];
		inDegree = new int[vertexCount];
		for(int i=0;i<vertexCount;i++) {
			adj[i] = new LinkedList<>();
			inDegree[i] = 0;
		}		
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
		inDegree[v]++;
	}
	
	public void kahnTopologicalSort() {
		int count = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<v;i++)
			if(inDegree[i] == 0)
				queue.add(i);
		
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			result.add(vertex);
			
			for(int i: adj[vertex]) {
				if(--inDegree[i] == 0)
					queue.add(i);
			}
			count++;
		}
		
		if(count != v)
			System.out.println("It has cycle");
		
		else {
			for(int i: result)
				System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		KahnTopologicalSort g = new KahnTopologicalSort(6);
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        
        g.kahnTopologicalSort();
	}
}
