package trees;

/*
 Example:

Input : 

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */
public class PrintAllAncestors {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(7);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(6);
		root.right.right = new TreeNode(1);
		root.right.left = new TreeNode(3);
		
		TreeNode node = new TreeNode(3);
		print(root,node);
	}

	public static boolean print(TreeNode root, TreeNode node) {
		if(root == null ) return false;
		if(root.val == node.val) return true;// root traversed to the node value and they are equal.
		if(print(root.left,node) || print(root.right,node)) {
			System.out.println(root.val);
			return true;
		}
		return false;
	}
	
}
