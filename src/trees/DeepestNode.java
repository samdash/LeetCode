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
          \
           6

*/
public class DeepestNode {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(6);

		DeepestNode dp = new DeepestNode();
		System.out.println("Deepest child is: " + dp.Deep(root));
		System.out.println("Using Queue --> "+dp.deepestNode(root).val);
	}
	
	public int Deep(TreeNode root) {
		find(root, 0);
		return value;
	}
	
	int deepestlevel = 0;
	int value = 0;

	public void find(TreeNode root, int level) {
		if (root != null) {
			level++;
			find(root.left, level);
			if (level > deepestlevel) {
				value = root.val;
				deepestlevel = level;
			}
			find(root.right, level);
		}
	}

	// The last node processed from queue in level order is the deepest node in binary tree.

	public TreeNode deepestNode(TreeNode root) {
		TreeNode temp = null;
		
		if(root == null) return null;
		
		Queue<TreeNode> q = new LinkedList<>();
		
		q.offer(root);
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp.left != null) q.offer(temp.left);
			if(temp.right != null) q.offer(temp.right);
		}
		return temp;
	}

}
