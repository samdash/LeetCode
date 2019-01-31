package trees;

import java.util.LinkedList;
import java.util.Queue;


/*
 
          1
         / \
        2   3
       / \     
      4   5    

 */
public class DiagonalsOfBT {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		printDiagonal(root);
	}
	
	public static void printDiagonal(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();

		q.offer(root);
		q.offer(null);
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			if(node == null) {
				q.offer(null);
				node = q.poll();
				if(node == null) break;
			}
			
			while(node!=null ) {
				System.out.print(node.val+" ");
				if(node.left != null)  q.offer(node.left);
				node = node.right;
			} 
		}
		
	}
}
