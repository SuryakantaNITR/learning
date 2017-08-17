package com.learning.ds;

public class BasicBST {
	BNode root;	
	
	public BasicBST() {
		this.root=null;
	}
	
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
	
	public boolean find(BNode root, int key) {
		if(root == null)
			return false;
		if(root.data == key)
			return true;
		if(key<root.data)
			return find(root.left, key);
		else if(key>root.data)
			return find(root.right, key);
		
		return false;
		
	}
	
	public void print(BNode root) {
		if(root == null)
			return;
		
		print(root.left);
		
		System.out.print(root.data + " ");
		
		print(root.right);
	}
	
	public void delete(int key) {
		deleteRecursive(root, key);
	}
	
	BNode deleteRecursive(BNode root, int key) {
		if(root == null)
			return root;
		
		if(key < root.data)
			root.left = deleteRecursive(root.left, key);
		
		else if(key > root.data)
			root.right = deleteRecursive(root.right, key);
		
		else {
			if(root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			
			root.data = getInorderSuccessor(root.right);
			
			root.right = deleteRecursive(root.right, root.data);
		}
		
		return root;
	}
	
	int getInorderSuccessor(BNode root) {
		int min = root.data;
		while(root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		return min;
	}
	public static void main(String[] args) {
		BasicBST bst = new BasicBST();
		bst.root = bst.insert(bst.root, 50);
		bst.root = bst.insert(bst.root, 30);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 40);
		bst.root = bst.insert(bst.root, 60);
		bst.root = bst.insert(bst.root, 70);
		bst.root = bst.insert(bst.root, 80);
		
		bst.print(bst.root);
		
//		boolean result = bst.find(bst.root, 100);
//		System.out.println(result);
		
		bst.delete(50);
		
		bst.print(bst.root);
	}
	
}
