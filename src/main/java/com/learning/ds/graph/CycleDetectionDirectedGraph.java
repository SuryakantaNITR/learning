package com.learning.ds.graph;

public class CycleDetectionDirectedGraph {
	
	public boolean isCyclicUtil(Graph<Integer> graph, Vertex<Integer> v, boolean[] visited, boolean[] isRecursing) {
		if(!visited[v.getData()]) {
			visited[v.getData()] = true;
			isRecursing[v.getData()] = true;
			
			for(Vertex<Integer> vertex: v.getAdjacentVertices()) {
				if(!visited[vertex.getData()] && isCyclicUtil(graph, vertex, visited, isRecursing))
					return true;
				else if(isRecursing[vertex.getData()])
					return true;
			}
		}
		isRecursing[v.getData()] = false;
		return false;
	}
	public boolean isCyclic(Graph<Integer> graph) {
		int verticesCount = graph.allVertices.size();
		boolean[] isVisited = new boolean[verticesCount];
		boolean[] isRecursing = new boolean[verticesCount];
		
		for(int i = 0; i < verticesCount; i++) {
	        isVisited[i] = false;
	        isRecursing[i] = false;
	    }
		
		for(Vertex<Integer> v: graph.getAllVertices()) {
			if(isCyclicUtil(graph, v, isVisited, isRecursing))
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		CycleDetectionDirectedGraph c = new CycleDetectionDirectedGraph();
		Graph<Integer> g = new Graph<>(true);
		g.addEdge(0, 1, 1);
	    g.addEdge(0, 2, 1);
	    g.addEdge(1, 2, 1);
	    g.addEdge(2, 0, 1);
	    g.addEdge(2, 3, 1);
	    g.addEdge(3, 3, 1);
	    
	    System.out.println(c.isCyclic(g));
	}

}
