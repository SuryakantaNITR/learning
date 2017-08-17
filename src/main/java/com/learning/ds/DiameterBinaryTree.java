package com.learning.ds;


class Height
{
 int h;
}

/* Class to print the Diameter */
class DiameterBinaryTree
{
 BNode root;

 /* define height =0 globally and  call diameterOpt(root,height)
    from main */
 int diameterOpt(BNode root, Height height)
 {
     /* lh --> Height of left subtree
        rh --> Height of right subtree */
     Height lh = new Height(), rh = new Height();

     if (root == null)
     {
         height.h = 0;
         return 0; /* diameter is also 0 */
     }
      
     /* ldiameter  --> diameter of left subtree
        rdiameter  --> Diameter of right subtree */ 
     /* Get the heights of left and right subtrees in lh and rh
      And store the returned values in ldiameter and ldiameter */
     if(root.left != null)
    	 lh.h++;
     if(root.right != null)
    	 rh.h++; 
     int ldiameter = diameterOpt(root.left, lh);
     int rdiameter = diameterOpt(root.right, rh);

     /* Height of current BNode is max of heights of left and
      right subtrees plus 1*/
     height.h = Math.max(lh.h, rh.h) + 1;

     return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
 }

 /* A wrapper over diameter(BNode root) */
 int diameter()
 {
     Height height = new Height();
     return diameterOpt(root, height);
 }

 /*The function Compute the "height" of a tree. Height is the
   number f BNodes along the longest path from the root BNode
   down to the farthest leaf BNode.*/
 static int height(BNode BNode)
 {
     /* base case tree is empty */
     if (BNode == null)
         return 0;

     /* If tree is not empty then height = 1 + max of left
        height and right heights */
     return (1 + Math.max(height(BNode.left), height(BNode.right)));
 }

 public static void main(String args[])
 {
     /* creating a binary tree and entering the BNodes */
     DiameterBinaryTree tree = new DiameterBinaryTree();
     tree.root = new BNode(1);
     tree.root.left = new BNode(2);
     tree.root.right = new BNode(3);
     tree.root.left.left = new BNode(4);
     tree.root.left.right = new BNode(5);

     System.out.println("The diameter of given binary tree is : "
                        + tree.diameter());
 }
}
