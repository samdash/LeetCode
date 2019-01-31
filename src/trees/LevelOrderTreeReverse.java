package trees;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/*
Example:
Given a binary tree 

         1
        / \
       2   3
      / \     
     4   5    
     

*/
public class LevelOrderTreeReverse {

	public void reverseBFS(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		q.add(root);// add the root TreeNode to the queue
		while (!q.isEmpty()) {
			// add the children to the queue
			TreeNode n = q.remove();
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
			// add the extracted TreeNode to the Stack
			s.add(n);
		}
		// now print all the TreeNode in Stack
		while (s.isEmpty() == false) {
			System.out.print(s.pop().val + " ");
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		LevelOrderTreeReverse i = new LevelOrderTreeReverse();
		i.reverseBFS(root);

	}
	
}
