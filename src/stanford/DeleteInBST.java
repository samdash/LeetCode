package stanford;

import java.util.LinkedList;
import java.util.Queue;

/*
 key = 3

    5
   / \
  3   6
 / \   \
2   4   7


 */

public class DeleteInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);

		DeleteInBST dib = new DeleteInBST();
		root = dib.remove(root, 5); // 3
		dib.levelOrder(root);
		
	}
	
	public TreeNode remove(TreeNode root, int data) {
		
		if(root == null) {
			return root;
		}
		else if(data < root.val) {
			root.left = remove(root.left,data);
		}else if(data > root.val) {
			root.right= remove(root.right,data);
		}else {
			// data is equal to root.val
			if(root.left == null && root.right == null) { 
				// Case 1 : this is the leaf root , so just null it to remove it
				root = null;
				return root;
				
			}else if( root.right == null) {
				// Case 2: has left child only 
				root = root.left;
				return root;
				
			}else if(root.left == null) {
				// Case 3: has right child only
				root = root.right;
				return root;
				
			}else {
				// Case 4: has Left and Right subtrees
				int value = getMin(root).val; // get min value from the right side
				root.val = value;
				root.right = remove(root.right,value);
				return root;
			}
		}
		return root;
	}
	
    private TreeNode getMin(TreeNode root) {
        TreeNode cur = root.right;
        while (cur != null && cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public void levelOrder(TreeNode root){
        if(root == null){
            System.out.println("Please enter a valid tree!");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            System.out.print(root.val + " ");
            if(root.left != null){
                queue.add(root.left);
            }
            if(root.right != null){
                queue.add(root.right);
            }
        }
    }

}
