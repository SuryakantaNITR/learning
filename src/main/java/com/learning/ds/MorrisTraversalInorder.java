package com.learning.ds;

public class MorrisTraversalInorder {
	BNode root;
	
	public void traverse(BNode root) {
		if(root == null)
			return;
		BNode current = root;
		while(current != null) {
			if(current.left == null) {
				System.out.println(current.data);
				current = current.right;
			}
			else {
				BNode pre = current.left;
				while(pre.right != null && pre.right != current)
					pre = pre.right;
				if(pre.right == null) {
					pre.right = current;
					current = current.left;
				}
				else {
					pre.right = null;
					System.out.println(current.data);
					current = current.right;
				}
					
			}
		}
	}
	
	public static void main(String[] args) {
		MorrisTraversalInorder mti = new MorrisTraversalInorder();
		mti.root = new BNode(1);
		mti.root.left = new BNode(2);
		mti.root.right = new BNode(3);
		mti.root.left.left = new BNode(4);
		mti.root.left.right = new BNode(5);
		mti.traverse(mti.root);
		
	}
}
