package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;


/*
Example:
Given a binary tree 

         1
        / \
       2   3
      / \     
     4   5    
     

*/

public class TopViewBT {

	public static TreeMap<Integer, Integer> ht = new TreeMap<>();;

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);


		TopViewBT p = new TopViewBT();
		p.topView(root, 0);
		display();
	}

	public void topView(TreeNode root, int level) {
		if (root == null)
			return;
		// create a queue for level order traversal
		Queue<QueuePack> queue = new LinkedList<>();
		// add root with level 0 (create a queue item pack)
		queue.add(new QueuePack(level, root));
		while (!queue.isEmpty()) {
			QueuePack q = queue.remove();
			// take out the items from the package
			TreeNode tnode = q.tnode;
			int lvl = q.level;

			// check if this is the first node you are visiting at the level
			if (!ht.containsKey(lvl)) {
				ht.put(lvl, tnode.val);
			} 

			// add the left and right children of visiting nodes to the queue
			if (tnode.left != null) {
				queue.add(new QueuePack(lvl - 1, tnode.left));
			}
			if (tnode.right != null) {
				queue.add(new QueuePack(lvl + 1, tnode.right));
			}
		}

	}
	
	public static void display() { // print the bottom view.
		Set<Integer> keys = ht.keySet();
		for (Integer key : keys) {
			System.out.print(ht.get(key) + "  ");
		}

	}

}

