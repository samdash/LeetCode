package trees;

import java.util.Stack;
/*
 Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
 * */


public class ValidBSTUsingStackAndInOrder {

	
    Stack<Integer> stack = new Stack<Integer>();

	public void inOrder(TreeNode root){
	
		if(root != null){
		    inOrder(root.left);
		    stack.push(root.val);
		    inOrder(root.right);
		}
	}
	public boolean isValidBST(TreeNode root){
	
		if(root == null){
		    return true;
		}
		
		inOrder(root); // after inOrder values stored in stack as descending order : 3,2,1
		int i = (int)stack.pop(); // pop 3 ( which is root ) i ==3
		
		while(!stack.isEmpty()){
		    int j = (int)stack.pop(); // pop 2 : j  =2 
		    if(i <= j){ // 3 < 2 ? no
		        return false;
		    }
		    i = j; // i = 2, replace i with next number in the stack j
		}
		
		return true;
	}
}
