package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 Example:
Given a binary tree 

          1
         / \
        2   3
       / \     
      4   5    
      

 */
public class FindLeaves {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		FindLeaves fl = new FindLeaves();
		List<List<Integer>> leaves = fl.findLeaves(root);
		for(int i=0;i< leaves.size();i++) {
			List<Integer> list = leaves.get(i);
			System.out.println(list.toString());
		}

	}

	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        while (root != null) {
            List<Integer> leaves = getLeaves(root);
            root = removeLeaves(root);
            list.add(leaves);
        }
        
        return list;
    }
     private List<Integer> getLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left == null && node.right == null) {
                list.add(node.val);
            }
            else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        
        return list;
    } 
     
     
     private TreeNode removeLeaves(TreeNode root) {
         if (root == null) {
             return null;
         }
         
         if (root.left == null && root.right == null) {
             return null;
         }
         
         root.left = removeLeaves(root.left);
         root.right = removeLeaves(root.right);
         
         return root;
     }
     
     
}
