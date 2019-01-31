package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree, determine if it is a complete binary tree.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 

Example 1:

         1  
        /  \ 
       2    3 
      / \   /  
     4   5 6   


Input: [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), 
and all nodes in the last level ({4, 5, 6}) are as far left as possible.
Example 2:

       	 1  
        / \ 
       2   3 
      / \   \
     4   5   7 



Input: [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.
 */
public class CompleteTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6); //root.right.left = new TreeNode(6);
		
		boolean result = isCompleteTree(root);
		System.out.println(result);

	}

	/*
	Use BFS to do a level order traversal,
	add childrens to the bfs queue,
	until we met the first empty node.
	
	For a complete binary tree,
	there should not be any node after we met an empty one.
	 */
	public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();
    }
}
