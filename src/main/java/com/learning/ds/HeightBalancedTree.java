package com.learning.ds;

public class HeightBalancedTree {
	BNode root;
	
	public boolean isHeightBalanced(BNode root, Height height) {
		if(root == null) {
			height.h=0;
			return true;
		}
		Height lHeight = new Height(), rHeight = new Height();
		
		boolean l = isHeightBalanced(root.left, lHeight);
		boolean r = isHeightBalanced(root.right, rHeight);
		
		int lh = lHeight.h, rh = rHeight.h;
		
		height.h = (lh>rh?lh:rh) + 1;
		
		if(Math.abs(lh-rh)>=2)
			return false;
		
		else
			return l && r;
	}
	
	public static void main(String[] args) {
		Height h = new Height();
		HeightBalancedTree tree = new HeightBalancedTree();
		tree.root = new BNode(1);
		tree.root.left = new BNode(2);
		tree.root.right = new BNode(3);
		tree.root.left.left = new BNode(4);
		tree.root.left.right = new BNode(5);
		tree.root.right.left = new BNode(9);
		tree.root.right.right = new BNode(8);
		tree.root.left.left.left = new BNode(6);
		tree.root.left.left.right = new BNode(7);
		tree.root.left.left.right.left = new BNode(10);
		tree.root.left.left.right.right = new BNode(11);
		
		if(tree.isHeightBalanced(tree.root, h))
			System.out.println("Balanced");
		else
			System.out.println("Not balanced");
	}

}
