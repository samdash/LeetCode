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
      

 */
public class UpsideDownBT {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		UpsideDownBT bt = new UpsideDownBT();
		System.out.print("Original Tree: ");
		bt.levelOrder(root);System.out.println();
		TreeNode node = bt.upsideDownBinaryTree(root);
		System.out.print("Upside Down Tree: ");
		bt.levelOrder(node);
	}

	public TreeNode upsideDownBinaryTree(TreeNode root) {
	    if(root == null || root.left == null) {
	        return root;
	    }
	    
	    TreeNode newRoot = upsideDownBinaryTree(root.left);
	    root.left.left = root.right;   // node 2 left children
	    root.left.right = root;         // node 2 right children
	    root.left = null;
	    root.right = null;
	    return newRoot;
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
