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
public class FindSecondLargestElementBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(4);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(8);
		
		FindSecondLargestElementBST sbt = new FindSecondLargestElementBST();
		int value = sbt.secondLargest(root);
		System.out.println(value);
	}
	
	int count = 0;
	int result = Integer.MIN_VALUE;

	public int secondLargest(TreeNode root) {
		int k = 2;
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

	
	
}
