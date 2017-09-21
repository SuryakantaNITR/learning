package com.learning.ds.tree;

import java.util.Stack;

class Node {
	int data, height;
	Node left, right;
	
	public Node(int data) {
		this.data = data;
		this.height = 1;
	}
}

public class AVLTree {
	
	Node root;
	
	public int height(Node node) {
		if(node == null)
			return 0;
		
		else
			return node.height;
	}
	
	public int getHeightDiff(Node node) {
		if(node == null)
			return 0;
		return height(node.left) - height(node.right);
	}
	
	public void updateHeight(Node node) {
		node.height = 1 + Math.max(height(node.left), height(node.right));
	}
	
	public Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;
		
		y.left = x;
		x.right = T2;
		
		updateHeight(x);
		updateHeight(y);
		
		return y;
	}
	
	public Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;
		
		x.right = y;
		y.left = T2;
		
		updateHeight(y);
		updateHeight(x);
		
		return x;
	}
	
	public Node insert(Node node, int data) {
		
		if(node == null) {
			return new Node(data);
		}
		
		if(node.data > data)
			node.left = insert(node.left, data);
		else if(node.data < data)
			node.right = insert(node.right, data);
		else
			return node;
		
		updateHeight(node);
		
		int heightDiff = getHeightDiff(node);
		
		if(heightDiff > 1 && node.left.data > data) {
			return rightRotate(node);
		}
		
		if(heightDiff < -1 && node.right.data < data) {
			return leftRotate(node);
		}
		if(heightDiff > 1 && node.left.data < data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		
		if(heightDiff < -1 && node.right.data > data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		
		
		return node;
	}
	
	public void preOrder() {
		Node current = this.root;
		if(current == null)
			return;
		
		Stack<Node> stack = new Stack<>();
		stack.push(current);
		
		while(!stack.isEmpty()) {
			Node temp = stack.peek();
			System.out.print(temp.data+" ");
			stack.pop();
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
		}
	}
	
	public void preOrder(Node node) {
		if(node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 25);
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder();
	}
}
