package com.learning.ds;

public class LowestCommonAncestor {
	BNode root;
	static boolean v1=false, v2=false;
	
	public BNode findLCAUtil(BNode root, int n1, int n2) {
		if(root == null)
			return null;
		
		if(root.data == n1) {
			v1=true;
			return root;
		}
		if(root.data == n2) {
			v2=true;
			return root;
		}
		
		BNode left = findLCAUtil(root.left, n1, n2);
		BNode right = findLCAUtil(root.right, n1, n2);
		
		if(left != null && right != null)
			return root;
		
		return (left!=null)?left:right;
		
	}
	public BNode findLCA(int n1, int n2) {
		v1=false;
		v2=false;
		BNode node = findLCAUtil(root, n1, n2);
		
		if(v1 && v2)
			return node;
		else
			return null;
	}
	public static void main(String[] args) {
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new BNode(1);
        tree.root.left = new BNode(2);
        tree.root.right = new BNode(3);
        tree.root.left.left = new BNode(4);
        tree.root.left.right = new BNode(5);
        tree.root.right.left = new BNode(6);
        tree.root.right.right = new BNode(7);
 
        BNode lca = tree.findLCA(4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");
 
        lca = tree.findLCA(4, 7);
        if (lca != null)
            System.out.println("LCA(4, 7) = " + lca.data);
        else
            System.out.println("Keys are not present");
	}

}
