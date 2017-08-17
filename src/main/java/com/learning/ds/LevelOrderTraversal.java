package com.learning.ds;

import java.util.LinkedList;
import java.util.Queue;

class BNode {
	int data;
	BNode left, right;
	
	public BNode(int data) {
		this.data=data;
		left=right=null;
	}
}

public class LevelOrderTraversal {
	BNode root;
	
	public void levelOrderTraversal() {
		Queue<BNode> queue = new LinkedList<BNode>();
		if(root == null)
			return;
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			BNode temp = queue.poll();
			System.out.print(temp.data + " ");
			
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}
		System.out.println(" ");
	}
	
	public void printLevels() {
		Queue<BNode> queue = new LinkedList<BNode>();
		if(root == null)
			return;
		
		queue.add(root);
		while(true) {
			int size = queue.size();
			if(size == 0)
				break;
			
			while(size>0) {
				BNode temp = queue.poll();
				System.out.print(temp.data + " ");
				
				if(temp.left != null)
					queue.add(temp.left);
				
				if(temp.right != null)
					queue.add(temp.right);
				size--;
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String[] args) {
		LevelOrderTraversal tree_level = new LevelOrderTraversal();
        tree_level.root = new BNode(1);
        tree_level.root.left = new BNode(2);
        tree_level.root.right = new BNode(3);
        tree_level.root.left.left = new BNode(4);
        tree_level.root.left.right = new BNode(5);
        
        tree_level.levelOrderTraversal();
        tree_level.printLevels();
	}
}
