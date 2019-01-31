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
     	/
       6

your output should be 4 2 5 3

How will you know that you are vis­it­ing the last node at every level(Vertically)?

1) Take a variable called level, whenever you go left, do level++ AND whenever you go right do level–.
2) With step above we have separated out the levels vertically.
3) Now you need to store the ele­ments of each level, so cre­ate a TreeMap and the (key,value) pair will be (level,element at that level).
4) Now all we need to do the level order tra­ver­sal and store only recent visited node at each level(vertically), this way you will be storing only the last element at each level.
5) We will use sim­ple queue tech­nique for level order tra­ver­sal or BFS.
6) we will cre­ate a class QueuePack, this will store the objects con­tain­ing node and its level.
7) At the end traverse through TreeMap and print all the values in it, it will be the bottom view of a tree. 
 
 
Example:
Given a binary tree 

         1  
        / \ 
       2   3 
      / \     
     4   5    
     

doing level order with level 

Output is : 4 2 5 3

*/

public class BottomViewOfBT {
	public static TreeMap<Integer, Integer> ht = new TreeMap<>();

	public static void bottomView(TreeNode root, int level) {
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
			// keep updating the Map so that it will have the last entry from
			// each level(vertically) and that will the bottom view of the tree
			ht.put(lvl, tnode.val);

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
			System.out.print(ht.get(key) + " ");
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		bottomView(root, 0);
		display();
	}
	
}

