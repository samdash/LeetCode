package trees;

/*
 Example:
Given a binary tree root = 1, p = 4, q = 0

         6
        / \
       4   7
      / \   \  
     3  5    8
          

 */
public class LowestCommonAncestorBST {

	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(4);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(8);
		
		TreeNode p = root.right.right; // 8 
		TreeNode q = root.left.left; // 3

		LowestCommonAncestorBST bst = new LowestCommonAncestorBST();
		TreeNode node = bst.LCA(root, p, q);
		System.out.println(node.val);
	}
	
	public  TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null)
			return root;
		if (root == a || root == b)
			return root;
		if (Math.max(a.val, b.val) < root.val) // a.val < root.val && b.val < root.val
			return LCA(root.left, a, b);
		else if (Math.min(a.val, b.val) > root.val) // a.val > root.val && b.val > root.val
			return LCA(root.right, a, b);
		else
			return root;
	}
}
