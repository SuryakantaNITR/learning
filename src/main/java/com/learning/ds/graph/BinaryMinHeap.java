package com.learning.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryMinHeap<T> {
	/**
	 * Data structure to support following operations
	 * extracMin - O(logn)
	 * addToHeap - O(logn)
	 * containsKey - O(1)
	 * decreaseKey - O(logn)
	 * getKeyWeight - O(1)
	 */
	
	class Node {
		T key;
		int weight;
	}
	
	List<Node> minHeap = new ArrayList<>();
	Map<T, Integer> positionMap = new HashMap<>();
	
	public boolean containsKey(int key) {
		return positionMap.containsKey(key);
	}
	
	public void add(T key, int weight) {
		Node node = new Node();
		node.key = key;
		node.weight = weight;
		
		minHeap.add(node);
		int size = minHeap.size();
		int current = size-1;
		int parent = (current-1)/2;
		
		positionMap.put(key, current);
		
		while(parent >= 0) {
			Node parentNode = minHeap.get(parent), currentNode = minHeap.get(current);
			if(parentNode.weight > currentNode.weight) {
				swap(parentNode, currentNode);
				updatePosition(parentNode.key, currentNode.key, parent, current);
				current = parent;
				parent = (parent - 1)/2;
			}
			else
				break;
		}
		
	}
	
	public T getMin() {
		return minHeap.get(0).key;
	}
	
	public void decreaseKey(T key, int newWeight) {
		int current = positionMap.get(key);
		Node node = minHeap.get(current);
		node.weight = newWeight;
		int parent = (current - 1)/2;
		while(parent >= 0) {
			Node parentNode = minHeap.get(parent), currentNode = minHeap.get(current);
			if(parentNode.weight > currentNode.weight) {
				swap(parentNode, currentNode);
				updatePosition(parentNode.key, currentNode.key, parent, current);
				current = parent;
				parent = (parent-1)/2;
			}
			else
				break;
		}
	}
	
	public Node extractMinNode() {
		Node minNode = new Node();
		
		minNode.weight = minHeap.get(0).weight;
		minNode.key = minHeap.get(0).key;
		
		int size = minHeap.size()-1;
		
		Node lastNode = minHeap.get(size);
		minHeap.get(0).weight = lastNode.weight;
		minHeap.get(0).key = lastNode.key;
		
		positionMap.remove(minNode.key);
		positionMap.remove(lastNode.key);
		positionMap.put(minHeap.get(0).key, 0);
		minHeap.remove(size);
		
		int current = 0;
		
		size--;
		
		while(true) {
			int left = 2*current + 1;
			int right = 2*current + 2;
			
			if(left>size)
				break;
			
			if(right>size)
				right = left;
			
			int small = minHeap.get(left).weight < minHeap.get(right).weight ? left : right;
			if(minHeap.get(current).weight > minHeap.get(small).weight) {
				swap(minHeap.get(current), minHeap.get(small));
				updatePosition(minHeap.get(current).key, minHeap.get(small).key, current, small);
				current = small;
			}
			else {
				break;
			}
			
		}
		return minNode;
	}
	
	public Integer getKeyWeight(T key) {
		if(positionMap.get(key) != null)
			return minHeap.get(positionMap.get(key)).weight;
		else
			return null;
	}
	
	public boolean isEmpty() {
		return minHeap.size() == 0;
	}
	
	public void swap(Node node1, Node node2) {
		int weight = node1.weight;
		T key = node1.key;
		
		node1.weight = node2.weight;
		node1.key = node2.key;
		
		node2.key = key;
		node2.weight = weight;
	}
	
	public void updatePosition(T key1, T key2, int pos1, int pos2) {
		positionMap.remove(key1);
		positionMap.remove(key2);
		
		positionMap.put(key1, pos1);
		positionMap.put(key2, pos2);
	}
	
}
