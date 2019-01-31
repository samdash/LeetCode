package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 */
public class PathWithSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(1);
		root.right.right.right = new TreeNode(1);
		
		System.out.println(hasPathSum(root,22));
		List<TreeNode> result = new ArrayList<>();
		boolean r = printPath(root, 22, result);
        if(r){
            for(int i=result.size()-1;i>=0;i--) {
            	System.out.print(result.get(i).val+" ");
            }

        }else{
            System.out.println("No path for sum " + 22); 
        }
        
        System.out.println();
        inOrderPrintPath(root,22);
 		
	}
	
	public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
    
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

	public static boolean printPath(TreeNode root, int sum, List<TreeNode> path){
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null && sum - root.val ==0){
        	path.add(root); return true;
        }
        if(printPath(root.left, sum-root.val, path) || printPath(root.right, sum - root.val, path)){
            path.add(root);
            return true;
        }
        return false;
    }
	// Print path using InOrder Traversal and using Stack.
	public static void inOrderPrintPath(TreeNode root, int k) {
		Stack<Integer> st = new Stack<Integer>();
		inOrderUtil(root,k,0,st);
		 
	}
	
	public static void inOrderUtil(TreeNode root, int k,int sum,Stack<Integer> st) {
		 if(root == null ) return;
		 sum += root.val;
		 st.push(root.val);
		 if(sum == k) {
			 while(!st.isEmpty()) {
				 System.out.print(st.pop()+" ");
			 }
		 }
		 
		 inOrderUtil(root.left,k,sum,st);
//		 System.out.println(root.val); // no need to print , we are just using inOrder
		 inOrderUtil(root.right,k,sum,st);
		 sum = sum - root.val;
		 if(!st.isEmpty())st.pop();
	}
	
	
}
