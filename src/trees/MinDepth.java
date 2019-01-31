package trees;

/*
 Example:
Given a binary tree 

          1
         / \
        2   3
       / \     
      4   5    
      
      

 */
public class MinDepth {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println("min depth --> "+ minDepth(root));
		System.out.println("max depth --> "+maxDepthII(root));

	}
	
	 public static int minDepth(TreeNode root) {
	        if(root == null) return 0; 
	        return 1 + Math.min(minDepth(root.left),minDepth(root.right)); 
	 }
	 
	 public static int maxDepthI(TreeNode root) {
	        if( root == null) return 0;
	        int left = maxDepthII(root.left);
	        int right = maxDepthII(root.right);
	        int max = Math.max(left,right) +1;
	        
	        return max;
	    }
	 // depth or height of the tree
	 public static int maxDepthII(TreeNode root) {
	        if(root == null) return 0; 
	        return 1 + Math.max(maxDepthII(root.left),maxDepthII(root.right)); 
	 }
	 

}
