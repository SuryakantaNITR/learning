package com.learning.ds;

public class PrintAncestors {
	BNode root;
	
	boolean printAncestors(BNode root, int target) {
		if(root == null)
			return false;
		
		if(root.data == target) 
			return true;
		
		boolean lVal = printAncestors(root.left, target);
		boolean rVal = printAncestors(root.right, target);
		if(lVal || rVal) {
			System.out.print(root.data + " ");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		 PrintAncestors tree = new PrintAncestors();
         
	        /* Construct the following binary tree
	                  1
	                /   \
	               2     3
	              /  \
	             4    5
	            /
	           7
	        */
	        tree.root = new BNode(1);
	        tree.root.left = new BNode(2);
	        tree.root.right = new BNode(3);
	        tree.root.left.left = new BNode(4);
	        tree.root.left.right = new BNode(5);
	        tree.root.left.left.left = new BNode(7);
	        tree.root.right.left = new BNode(9);
	        tree.root.right.right = new BNode(9);
	  
	        tree.printAncestors(tree.root, 9);
		
	}

}
