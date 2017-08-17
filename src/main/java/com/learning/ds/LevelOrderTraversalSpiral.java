package com.learning.ds;

import java.util.Stack;

public class LevelOrderTraversalSpiral {
	BNode root;
	
	public void inorderTraverse(BNode inputRoot) {
		if(inputRoot == null)
			return;
		
		inorderTraverse(inputRoot.left);
		System.out.print(inputRoot.data + " ");
		inorderTraverse(inputRoot.right);
	}
	
	public void levelOrderTraverseSpiral(BNode inputRoot) {
		if(inputRoot == null)
			return;
		
		Stack<BNode> s1 = new Stack<BNode>();
		Stack<BNode> s2 = new Stack<BNode>();
		
		s1.push(inputRoot);
		
		while(!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) {
				BNode temp = s1.pop();
				System.out.print(temp.data+" ");
				
				if(temp.right != null)
					s2.push(temp.right);
				if(temp.left != null)
					s2.push(temp.left);
			}
			System.out.println(" ");
			
			while(!s2.isEmpty()) {
				BNode temp = s2.pop();
				System.out.print(temp.data+" ");
				
				if(temp.left != null)
					s1.push(temp.left);
				
				if(temp.right != null)
					s1.push(temp.right);
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String[] args) {
		LevelOrderTraversalSpiral tree_level = new LevelOrderTraversalSpiral();
        tree_level.root = new BNode(1);
        tree_level.root.left = new BNode(2);
        tree_level.root.right = new BNode(3);
        tree_level.root.left.left = new BNode(4);
        tree_level.root.left.right = new BNode(5);
        tree_level.root.right.left = new BNode(6);
        tree_level.root.right.right = new BNode(7);
        
        System.out.println("Inorder before lot");
        tree_level.inorderTraverse(tree_level.root);
        System.out.println("LOT");
        tree_level.levelOrderTraverseSpiral(tree_level.root);
	}

}
