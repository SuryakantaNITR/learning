package com.learning.ds.graph;

import java.util.List;

public class PrimsMST<T> {
	public List<Edge<T>> mst(Graph<T> graph) {
		return null;
	}
	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<>(false);
		graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 3);
        graph.addEdge(2, 4, 2);
        graph.addEdge(6, 5, 2);
        graph.addEdge(6, 4, 3);
        graph.addEdge(4, 7, 2);
        graph.addEdge(3, 4, 5);
        graph.addEdge(3, 7, 8);
        
        
	}
}
