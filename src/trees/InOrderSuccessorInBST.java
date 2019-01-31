package trees;

/*
 
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

Example 1:

Input: root = [2,1,3], p = 1

  2
 / \
1   3

Output: 2
Example 2:

Input: root = [5,3,6,2,4,null,null,1], p = 6

      5
     / \
    3   6
   / \
  2   4
 /   
1

Output: null
*/
public class InOrderSuccessorInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3); 
		
		TreeNode p = new TreeNode(1);

		InOrderSuccessorInBST bt = new InOrderSuccessorInBST();
		TreeNode node = bt.inorderSuccessor(root, p);
		System.out.println(node.val);

	}
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		  if (root == null)
		    return null;

		  if (root.val <= p.val) {
		    return inorderSuccessor(root.right, p);
		  } else {
		    TreeNode left = inorderSuccessor(root.left, p);
		    return (left != null) ? left : root;
		  }
	}
	
	
	public TreeNode inOrderPredecessor(TreeNode root, TreeNode p) {
		  if (root == null)
		    return null;

		  if (root.val >= p.val) {
		    return inOrderPredecessor(root.left, p);
		  } else {
		    TreeNode right = inOrderPredecessor(root.right, p);
		    return (right != null) ? right : root;
		  }
		}
}
