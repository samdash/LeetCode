package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
 Invert a binary tree.

Example:

Input : 

     4
   /   \
  7     2
 / \   / \
9   6 3   1

Output:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

 */
public class InvertBT {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(7);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(6);
		root.right.right = new TreeNode(1);
		root.right.left = new TreeNode(3);

		InvertBT bt = new InvertBT();
		System.out.print("Original Tree: ");
		bt.levelOrder(root);System.out.println();
		TreeNode node = bt.invertTree(root);
		System.out.print("Inverted Tree: ");
		bt.levelOrder(node);
		
	}
	
	public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        
        return root;
    }
	
	public void levelOrder(TreeNode root){
        if(root == null){
            System.out.println("Please enter a valid tree!");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.size() > 0){
            root = queue.poll();
            System.out.print(root.val + " ");
            if(root.left != null){
                queue.add(root.left);
            }
            if(root.right != null){
                queue.add(root.right);
            }
        }
    }

	
}
