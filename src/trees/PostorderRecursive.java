package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

PostOrder = L,R,V ( left, right, visit ) 
 */
public class PostorderRecursive {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		PostorderRecursive pr = new PostorderRecursive();
		
		System.out.println(pr.postorderTraversal(root).toString());
		System.out.println(pr.postorderTraversalUsingStacks(root).toString());


	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		return helper(root, result);
    }
    private  List<Integer> helper(TreeNode root, List<Integer> result) {
		if (root != null) {
			helper(root.left,result);
			helper(root.right,result);
			result.add(root.val);

		}
		return result;
	}
    
    public List<Integer> postorderTraversalUsingStacks(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) {
            return values;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.empty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp);

            if (temp.left != null) {
                stack1.push(temp.left);
            }

            if (temp.right != null) {
                stack1.push(temp.right);
            }
        }

        while (!stack2.empty()) {
            values.add(stack2.pop().val);
        }
        
        return values;
    }
}
