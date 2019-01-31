package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Example:
Given a binary tree 

          1
         / \
        2   3
       / \     
      4   5    


your max sum would be at the last level : 4 + 5 = 9
 */

public class FindLevelwithMaxSum {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		FindLevelwithMaxSum flm = new FindLevelwithMaxSum();
		int result = flm.findLevelwithMaxSum(root);
		System.out.println(result);
		
	}
	
	public int findLevelwithMaxSum(TreeNode root) {
		int maxSum = 0, currentSum = 0;
		if (root == null)
			return 0;
		// Initialization
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			TreeNode tmp = q.poll();
			if (tmp != null) {
				currentSum = currentSum + tmp.val;
				if (tmp.left != null)
					q.offer(tmp.left);
				if (tmp.right != null)
					q.offer(tmp.right);
			} else {
				if (currentSum > maxSum){
					maxSum =  currentSum;
				}
				currentSum = 0;
				// completion of a level;
				if (!q.isEmpty())
					q.offer(null);
			}
		}
		return maxSum;
	}
}
