package com.learning.ds.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Graph<T> {
	List<Edge<T>> allEdges;
	Map<Long, Vertex<T>> allVertices;
	boolean isDirected = false;
	
	public Graph(boolean isDirected) {
		allEdges = new ArrayList<Edge<T>>();
		allVertices = new HashMap<Long, Vertex<T>>();
		this.isDirected = isDirected;
	}

	public List<Edge<T>> getAllEdges() {
		return allEdges;
	}

	
	
	public void addEdge(long id1, long id2) {
		addEdge(id1, id2, 0);
	}
	
	public void addVertex(Vertex<T> vertex) {
		if(allVertices.containsKey(vertex.getId()))
			return;
		
		allVertices.put(vertex.getId(), vertex);
		
		for(Edge<T> edge: vertex.getEdges())
			allEdges.add(edge);
	}
	
	public Vertex<T> addSingleVertex(long id) {
		if(allVertices.containsKey(id))
			return allVertices.get(id);
		
		Vertex<T> vertex = new Vertex<T>(id);
		allVertices.put(id, vertex);
		return vertex;
	}
	
	public Vertex<T> getVertex(long id) {
		return allVertices.get(id);
	}
	
	public void addEdge(long id1, long id2, int weight) {
		Vertex<T> v1 = addSingleVertex(id1);
		Vertex<T> v2 = addSingleVertex(id2);
		
		Edge<T> edge = new Edge<T>(v1, v2, weight, isDirected);
		allEdges.add(edge);
		v1.addAdjacentVertex(v2, edge);
		if(!isDirected)
			v2.addAdjacentVertex(v1, edge);
	}
	
	public Collection<Vertex<T>> getAllVertices() {
		return allVertices.values();
	}
	public void setDataForVertex(long id, T data){
        if(allVertices.containsKey(id)){
            Vertex<T> vertex = allVertices.get(id);
            vertex.setData(data);
        }
    }
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(Edge<T> edge: allEdges) {
			sb.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
		}
		return sb.toString();
	}

}

class Vertex<T> {
	long id;
	private T data;
	private List<Edge<T>> edges = new ArrayList<>();
	private List<Vertex<T>> adjacentVertices = new ArrayList<>();
	
	public Vertex(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<Edge<T>> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge<T>> edges) {
		this.edges = edges;
	}
	public List<Vertex<T>> getAdjacentVertices() {
		return adjacentVertices;
	}
	public void setAdjacentVertices(List<Vertex<T>> adjacentVertices) {
		this.adjacentVertices = adjacentVertices;
	}
	
	public void addAdjacentVertex(Vertex<T> v, Edge<T> e) {
		edges.add(e);
		adjacentVertices.add(v);
	}
	
	public String toString(){
        return String.valueOf(id);
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}

class Edge<T> {
	int weight;
	Vertex<T> vertex1;
	Vertex<T> vertex2;
	boolean isDirected=false;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
		result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (vertex1 == null) {
			if (other.vertex1 != null)
				return false;
		} else if (!vertex1.equals(other.vertex1))
			return false;
		if (vertex2 == null) {
			if (other.vertex2 != null)
				return false;
		} else if (!vertex2.equals(other.vertex2))
			return false;
		return true;
	}

	
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Vertex<T> getVertex1() {
		return vertex1;
	}

	public void setVertex1(Vertex<T> vertex1) {
		this.vertex1 = vertex1;
	}

	public Vertex<T> getVertex2() {
		return vertex2;
	}

	public void setVertex2(Vertex<T> vertex2) {
		this.vertex2 = vertex2;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}
	
	public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight, boolean isDirected) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
		this.weight = weight;
	}
	
	
	
}
