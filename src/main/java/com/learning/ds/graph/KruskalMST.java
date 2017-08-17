package com.learning.ds.graph;

import java.util.Arrays;

public class KruskalMST {
	int V, E;
	Edge[] edge;
	
	public KruskalMST(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		
		for(int i=0;i<E;i++) {
			edge[i] = new Edge();
		}
	}
	
	class Subset {
		int parent, rank;
	}
	
	class Edge implements Comparable<Edge>{
		int src, dest, weight;

		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	
	public int find(Subset[] subset, int i) {
		if(subset[i].parent != i)
			subset[i].parent =  find(subset, subset[i].parent);
		
		return subset[i].parent;
	}
	
	public void union(Subset[] subset, int x, int y) {
		int xset = find(subset, x);
		int yset = find(subset, y);
		
		if(subset[xset].rank<subset[yset].rank)
			subset[xset].parent = yset;
		
		else if(subset[yset].rank<subset[xset].rank)
			subset[yset].parent = xset;
		
		else {
			subset[yset].parent = xset;
			subset[xset].rank++;
		}
	}
	public void mst() {
		Subset[] subset = new Subset[V];
		for(int i=0;i<V;i++) {
			subset[i] = new Subset();
			subset[i].rank = 0;
			subset[i].parent = i;
		}
		Edge[] result = new Edge[E];
		for(int i=0;i<E;i++) {
			result[i] = new Edge();
		}
		
		Arrays.sort(edge);
		
		int e=0, i=0;
		while(e<V-1) {
			Edge nextEdge = new Edge();
			nextEdge = edge[i++];
			
			int x = find(subset, nextEdge.src);
			int y = find(subset, nextEdge.dest);
			
			if(x != y) {
				result[e++] = nextEdge;
				
			}
		}
		for(i=0;i<E;i++)
			System.out.println(result[i].src +  " " + result[i].dest + " " + result[i].weight);
		
	}
	public static void main(String[] args) {
		int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        KruskalMST graph = new KruskalMST(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;
 
        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;
 
        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;
 
        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;
 
        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;
 
        graph.mst();
	}

}
