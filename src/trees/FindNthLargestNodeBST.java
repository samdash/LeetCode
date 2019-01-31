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
public class FindNthLargestNodeBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(4);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(8);
		int n = 2;
		FindNthLargestNodeBST fnl = new FindNthLargestNodeBST();
		fnl.printReverseInOrder(root);System.out.println();
		int value = fnl.findNthLargest(root, n);
		System.out.println(n+" largest value : "+value);
		
	}
	
	// If we do reverse InOrder traversal of BST we get output as 8,7,6,5,4,3, so nth largest would be nth element in the order.
	// Reverse InOrder is R,V,L
	int count = 0;
	int result = Integer.MIN_VALUE;

	public int findNthLargest(TreeNode root, int k) {
	    traverse(root, k);
	    return result;
	}

	public void traverse(TreeNode root, int k) {
	    if(root == null) return;
	    traverse(root.right, k);
	    count ++;
	    if(count == k) result = root.val;
	    traverse(root.left, k);       
	}
	
	public void printReverseInOrder(TreeNode node) {
		if(node == null) return;
		printReverseInOrder(node.right);
		System.out.print(node.val+" ");
		printReverseInOrder(node.left);
		
	}
	
}
