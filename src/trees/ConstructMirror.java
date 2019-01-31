package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Example:
Given a binary trees 

Input 
         1
        / \
       2   3
      /   /  
     4   5    

Output : 

         1
        / \
       3   2
        \   \  
         5   4    


*/
public class ConstructMirror {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		
		ConstructMirror cm = new ConstructMirror();
		System.out.print("Original Tree --> ");
		cm.printLevelOrder(root);
		TreeNode node = cm.contructMirror(root);
		System.out.print("\nMirror of Above Tree --> ");
		cm.printLevelOrder(node);
		
	}
	public TreeNode contructMirror(TreeNode root) {
		 TreeNode temp ;
		 if(root != null) {
			 contructMirror(root.left);
			 contructMirror(root.right);
			 temp = root.left;
			 root.left = root.right;
			 root.right = temp;
		 }
		 
		 return root;
	}
	
	public void printLevelOrder(TreeNode root) {
		
		if(root == null ) return;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			TreeNode n = q.poll();
			System.out.print(n.val+ " ");
			if(n.left != null) q.offer(n.left);
			if(n.right != null) q.offer(n.right);
			
		}
	}
	
}
