package trees;


/*
 Given a binary tree, you need to compute the length of the diameter of the tree.
 The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 

          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
in other words, ( longest left path + longest right path + 1 )
 */
public class DiameterOfTree {

int max = 0;
    


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
	
		DiameterOfTree d = new DiameterOfTree();
		System.out.println("Diameter of Tree: " + d.diameterOfBinaryTree(root));
	
	}
	
	

    public int diameterOfBinaryTree(TreeNode root) {
        return maxDepth(root);
        //return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
       // max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1; // +1 is for the root
    }
    
	
	// Alternative Coding
	public int diameter(TreeNode root){
		if(root==null) return 0;

		//the path goes through the root
		int len1 = height(root.left) + height(root.right) +3;

		//the path does not pass the root
		int len2 = Math.max(diameter(root.left), diameter(root.right));

		return Math.max(len1, len2);
	}
	public int height(TreeNode root) {
		if(root == null) 
			return 0;
		/* compute the depth of each subtree */
		int leftDepth = height(root.left);
		int rightDepth = height(root.right);
		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	} 
}
