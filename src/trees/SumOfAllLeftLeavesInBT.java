package trees;


/*
Approach:

Approach is quite simple.
Do the inorder traversal
check if node is the left child and leaf node.
If yes then add it to the sum.

Example:
Given a binary tree 

         8  
        / \ 
       2   9 
      / \     
     4   5
        /
       3    
     
output = 4 + 3 = 7

 */
public class SumOfAllLeftLeavesInBT {

		public static int leftLeavesSum = 0;

		public static void main(String args[]) {
			TreeNode root = new TreeNode(1);
			root.left = new TreeNode(2);
			root.right = new TreeNode(3);
			root.left.left = new TreeNode(4);
			root.left.right = new TreeNode(5);
			root.left.right.left = new TreeNode(3);

			SumOfAllLeftLeavesInBT sbt = new SumOfAllLeftLeavesInBT();
			sbt.leftSum(root, root);
			System.out.println("Sum of left leaves: " + leftLeavesSum);
			
			int result = sbt.sumOfLeftLeaves(root);
			System.out.println(result);
		}
			
		// Do the inorder traversal
		// check if node is the left child and leaf node
		// if yes then add it to the sum

		public  void leftSum(TreeNode root, TreeNode parent) {
			if (root != null) {
				leftSum(root.left, root);
				if (root.left == null && root.right == null && parent.left == root) {
					leftLeavesSum += root.val;
				}
				leftSum(root.right, root);
			}
		}

		int count = 0;
	    public int sumOfLeftLeaves(TreeNode root) {
	        dfs(root, false);
	        return count;
	    }
	    
	    public void dfs(TreeNode root, boolean toLeft){
	        if (root == null) return;
	        if (toLeft)
	            if (root.left == null && root.right == null)
	                count += root.val;
	        dfs(root.left, true);
	        dfs(root.right, false);
	    }
}
