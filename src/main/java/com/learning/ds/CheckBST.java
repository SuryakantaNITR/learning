package com.learning.ds;

public class CheckBST {
	BNode root;
	
	public BNode insert(BNode root, int data) {
		if(root == null) {
			return new BNode(data);
		}
		if(root.data > data)
			root.left = insert(root.left, data);
		else if(root.data < data)
			root.right = insert(root.right, data);
		
		return root;
	}
	
	public void print(BNode root) {
		if(root == null)
			return;
		
		print(root.left);
		
		System.out.print(root.data + " ");
		
		print(root.right);
	}
	public boolean isBST(BNode root, int min, int max) {
		if(root == null)
			return true;
		if(root.data > max || root.data < min)
			return false;
		return isBST(root.left, min, root.data-1) && isBST(root.right, root.data+1, max);
	}
	
	
	public static void main(String[] args) {
		CheckBST bst = new CheckBST();
		bst.root = bst.insert(bst.root, 50);
		bst.root = bst.insert(bst.root, 30);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 40);
		bst.root = bst.insert(bst.root, 60);
		bst.root = bst.insert(bst.root, 70);
		bst.root = bst.insert(bst.root, 80);
		
		bst.print(bst.root);
		System.out.println(bst.isBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

}
