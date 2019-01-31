package trees;

import java.util.ArrayList;
import java.util.List;


/*
 * 
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]

PreOrder = V, L , R  ( visit, left, right ) 

 */
public class PreorderRecursive {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);

		PreorderRecursive pr = new PreorderRecursive();
		List<Integer> list = pr.preorderTraversal(root);
		System.out.println(list.toString());
	}
	
	
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		return helper(root, result);
    }
    private static List<Integer> helper(TreeNode root, List<Integer> result) {
		if (root != null) {
			result.add(root.val);
			helper(root.left,result);
			helper(root.right,result);
		}
		return result;
	}
}
