package com.learning.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class KruskalMSTTwo {
	class EdgeComparator implements Comparator<Edge<Integer>> {

		@Override
		public int compare(Edge<Integer> o1, Edge<Integer> o2) {
			return o1.getWeight() - o2.getWeight();
		}
		
	}
	public List<Edge<Integer>> mst(Graph<Integer> graph) {
		List<Edge<Integer>> allEdges = graph.getAllEdges();
		
		Collections.sort(allEdges, new EdgeComparator());
		
		List<Edge<Integer>> result = new ArrayList<>();
		
		DisjointSet disjointSet = new DisjointSet();
		
		for(Vertex<Integer> vertex: graph.getAllVertices()) {
			disjointSet.makeSet(vertex.getId());
		}
		
		for(Edge<Integer> edge: graph.getAllEdges()) {
			long id1 = disjointSet.findSet(edge.getVertex1().getId());
			long id2 = disjointSet.findSet(edge.getVertex2().getId());
			
			if(id1 == id2)
				continue;
			
			result.add(edge);
			disjointSet.union(edge.getVertex1().getId(), edge.getVertex2().getId());
			
		}
		return result;
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
        
        KruskalMSTTwo k = new KruskalMSTTwo();
        List<Edge<Integer>> result = k.mst(graph);
        for (Edge<Integer> edge : result) {
            System.out.println(edge.getVertex1() + " " + edge.getVertex2());
        }
        
	}

}
