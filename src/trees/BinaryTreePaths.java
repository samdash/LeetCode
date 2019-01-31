package trees;

import java.util.LinkedList;
import java.util.List;

/*
 Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:
Given a binary tree 

          1
         / \
        2   3
       / \     
      4   5    
      
      
 */
public class BinaryTreePaths {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		BinaryTreePaths btp = new BinaryTreePaths();
		List<String> list = btp.binaryTreePaths(root);
		System.out.println(list.toString());
		
	}

	public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> paths = new LinkedList<>();

        if(root == null) return paths;
        
        if(root.left == null && root.right == null){
            paths.add(root.val+"");
            return paths;
        }

         for (String path : binaryTreePaths(root.left)) {
             paths.add(root.val + "->" + path);
         }

         for (String path : binaryTreePaths(root.right)) {
             paths.add(root.val + "->" + path);
         }

         return paths;
        
    }
}
