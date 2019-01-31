package trees;

/*
 Example:
Given a binary trees 

          1
         / \
        2   3
       /   /  
      4   5    


          1
         / \
        3   2
         \   \  
          5   4    


 */
public class Mirrors {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);

		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(2);
		root1.left.right = new TreeNode(5);
		root1.right.right = new TreeNode(4);

		System.out.println(areMirrors(root1, root));

	}
	
    public static boolean areMirrors(TreeNode  root1, TreeNode  root2) {
    	if(root1 == null && root2 == null) 	return true;
    	if(root1 == null || root2 == null) return false;
    	if(root1.val != root2.val) return false;
    	else return (areMirrors(root1.left, root2.right) && areMirrors(root1.right, root2.left));
     }
}
