package com.learning.ds.graph;

/**
 * 
 * @author suryakanta
 * Cycle detection for undirected graph
 */
public class CycleDetectionByUnion {
	class Graph {
		int V, E;
		Edge[] edge;
		
		class Edge {
			int src, dest;
		}
		public Graph(int v, int e) {
			V = v;
			E = e;
			edge = new Edge[e];
			for(int i=0;i<e;i++) {
				edge[i] = new Edge();
			}
		}
		
		public int findParent(int[] parent, int i) {
			if(parent[i] == -1)
				return i;
			return findParent(parent, parent[i]);
		}
		
		public void union(int[] parent, int x, int y) {
			int xset = findParent(parent, x);
			int yset = findParent(parent, y);
			parent[xset] = yset;
		}
		
		public boolean isCycle() {
			int[] parent = new int[V];
			
			for(int i=0;i<V;i++)
				parent[i] = -1;
			
			for(int i=0;i<E;i++) {
				int x = findParent(parent, edge[i].src);
				int y = findParent(parent, edge[i].dest);
				
				if(x == y)
					return true;
				
				union(parent, x, y);
			}
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		CycleDetectionByUnion o = new CycleDetectionByUnion();
		Graph graph = o.new Graph(3, 3);
		
		// add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
 
        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
        
        System.out.println(graph.isCycle());
	}

}
