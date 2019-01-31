package trees;



/*
 Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:
Given a binary tree 

          1
         / \
        2   3
       / \     
      4   5    
      
      
return its depth = 3.

MaxDepth and Height are the same
 *
 */
public class DepthOrHeight {

	 public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(maxDepth(root));
		System.out.println(maxDepthII(root));
	 }
	
	 public static int maxDepth(TreeNode root) {
	        if( root == null) return 0;
	        int left = maxDepth(root.left);
	        int right = maxDepth(root.right);
	        int max = Math.max(left,right) +1;
	        
	        return max;
	    }
	 
	 // depth or height of the tree
	 public static int maxDepthII(TreeNode root) {
	        if(root == null) return 0; 
	        return 1 + Math.max(maxDepthII(root.left),maxDepthII(root.right)); 
	 }
	 
	 
}
