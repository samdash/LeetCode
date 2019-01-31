package trees;

/*
 Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants 
(where we allow a node to be a descendant of itself).”

Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the BST.




Example:
Given a binary tree root = 1, p = 4, q = 0

         6
        / \
       2   7
      / \     
     0   3    
          \
           4


 */
public class LowestCommonAncestorBT {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(4);
		
		TreeNode p = root.left; // 2 
		TreeNode q = root.right; // 7
		
		LowestCommonAncestorBT lca = new LowestCommonAncestorBT();
		TreeNode node = lca.lowestCommonAncestor(root, p, q);
		System.out.println(node.val);
	}
	
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if( root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor( root.right,p,q);
        if(left!=null && right !=null) return root;
        if(left == null) return right;
        else return left;
    }

}
