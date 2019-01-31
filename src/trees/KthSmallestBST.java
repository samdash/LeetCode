package trees;


/*

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

*/
public class KthSmallestBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);

		KthSmallestBST ks = new KthSmallestBST();
		int result = ks.kthSmallest(root, 3);
		System.out.println(result);

	}

	int ans = 0;
    int val = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return val;
    }
    // inOrder traversal will result in 1,2,3,4,5,6
    // while traversing keeping track of number of nodes that are being visited is enough to determine the answer 
    // if k = 3 , then 3rd node value is the answer.
    public void helper(TreeNode node, int k) {
        if (node.left != null) {
            helper(node.left, k);
        }
        ans++;
        if (ans == k) { // once ans equals k, record the node value, and return.
            val = node.val;
            return;
        }
        if (node.right != null) {
            helper(node.right, k);
        }
    }
}
