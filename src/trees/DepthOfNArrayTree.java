package trees;

/*
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a 3-ary tree:

				1
			  / | \
			 3  2  4
			/ \
		   5   6
		   
We should return its max depth, which is 3.

Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
 */
public class DepthOfNArrayTree {

	public static void main(String[] args) {

	}

	private int max = 0;
	public int maxDepth(NArrayNode root) {
	    if (root == null) return 0;
	    maxDepth(root, 1);
	    return max;
	} 
	    
	public void maxDepth(NArrayNode node, int depth) {
	    if (node == null) return;
	    max = Math.max(max, depth);
	    for (NArrayNode child : node.children){
	        maxDepth(child, depth+1);
	    }
	}
}
