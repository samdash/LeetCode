package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 
Example:
Given a binary tree 

          1
         / \
        2   3
       / \     
      4   5    
  
 [
  [1],
  [2,3],
  [4,5]
] 
 

 */

public class LevelOrderTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		LevelOrderTree lot = new LevelOrderTree();
		lot.printLevelOrderTraversal(root);
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
	
	public void printLevelOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
         
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
         
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.val + " ");
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
