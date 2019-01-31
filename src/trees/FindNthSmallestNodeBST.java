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

public class FindNthSmallestNodeBST {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(4);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(8);
		
		FindNthSmallestNodeBST fns = new FindNthSmallestNodeBST();
		int n = 2;
		fns.printInorder(root);System.out.println();
		int value = fns.findNthSmallest(root, n);
		System.out.println(n+"nd smallest value: "+value);
		
	}

		// If we do  InOrder traversal of BST we get output as 3,4,5,6,7,8, so nth smallest would be nth element in the order.
		//  InOrder is L,V,R
		int count = 0;
		int result = Integer.MIN_VALUE;

		public int findNthSmallest(TreeNode root, int k) {
		    traverse(root, k);
		    return result;
		}

		public void traverse(TreeNode root, int k) {
		    if(root == null) return;
		    traverse(root.left, k);
		    count ++;
		    if(count == k) result = root.val;
		    traverse(root.right, k);       
		}
		
		public void printInorder(TreeNode node) {
			if(node == null) return;
			printInorder(node.left);
			System.out.print(node.val+" ");
			printInorder(node.right);
			
		}
}
