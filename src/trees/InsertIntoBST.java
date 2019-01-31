package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3
And the value to insert: 5
You can return this binary search tree:

         4
       /   \
      2     7
     / \   /
    1   3 5
This tree is also valid:

         5
       /   \
      2     7
     / \   
    1   3
         \
          4
          
          
Input : 

Example:
Given a binary tree 

         8
        / \
       6   9
      / \     
     5   7    
          

*/          

public class InsertIntoBST {
	
	   public static void main(String[] args) {
			TreeNode root = new TreeNode(8);
			root.left = new TreeNode(6);
			root.right = new TreeNode(9);
			root.left.left = new TreeNode(5);
			root.left.right = new TreeNode(7);
			InsertIntoBST bt = new InsertIntoBST();
			bt.levelOrder(root);System.out.println();
			TreeNode node = bt.insertIntoBST(root, 10);
			bt.levelOrder(node);
			
			
	   }
	   public TreeNode insertIntoBST(TreeNode root, int val) {
	        if(root == null) return new TreeNode(val);
	        if(val < root.val) 
	            root.left = insertIntoBST(root.left,val);
	        else 
	            root.right = insertIntoBST(root.right,val);
	        
	        return root;
	    }

		public void levelOrder(TreeNode root){
	        if(root == null){
	            System.out.println("Please enter a valid tree!");
	            return;
	        }
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            root = queue.poll();
	            System.out.print(root.val + " ");
	            if(root.left != null){
	                queue.add(root.left);
	            }
	            if(root.right != null){
	                queue.add(root.right);
	            }
	        }
	    }
}
