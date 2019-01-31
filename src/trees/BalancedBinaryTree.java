package trees;

/*
 Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
 
Return false.
 */
public class BalancedBinaryTree {

	
	boolean res = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return res;
        
    }
    private int maxDepth(TreeNode p) {
        if (p == null) {
            return 0;
        }
        int l = maxDepth(p.left);
        int r = maxDepth(p.right);
        if (Math.abs(l - r) > 1) {
            res = false;
        }
        return Math.max(l, r) + 1;
    }

}
