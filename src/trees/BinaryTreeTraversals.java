package trees;

import java.util.Deque;
import java.util.LinkedList;
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
public class BinaryTreeTraversals {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		BinaryTreeTraversals btt= new BinaryTreeTraversals();
		System.out.print("InOrder-> ");
		btt.inOrder(root);
		System.out.println();
		System.out.print("PreOrder-> ");
		btt.preOrder(root);
		System.out.println();
		System.out.print("PostOrder-> ");
		btt.postOrder(root);
		System.out.println();
		System.out.print("LevelOrder-> ");
		btt.levelOrder(root);
	}


	// L,V,R [ visited, Left, Right ] 
	public void inOrder(TreeNode n) {
		if( n!=null) {
			inOrder(n.left);
			System.out.print(n.val+" ");
			inOrder(n.right);
		}
	}
	
	// V,L,R
	public void preOrder(TreeNode n) {
		if(n!=null) {
			System.out.print(n.val+" ");
			preOrder(n.left);
			preOrder(n.right);
		}
	}
	
	// L,R,V
	
	public void postOrder(TreeNode n) {
		if(n!=null) {
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n.val+" ");
		}
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

	
	
	 public void inorderItr(TreeNode root){
	        Deque<TreeNode> stack = new LinkedList<TreeNode>();
	        TreeNode node = root;
	        while(true){
	            if(node != null){
	                stack.addFirst(node);
	                node = node.left;
	            }
	            else{
	                if(stack.isEmpty()){
	                    break;
	                }
	                node = stack.pollFirst();
	                System.out.print(node.val+" ");
	                node = node.right;
	            }
	        }
	    }
	    
	    public void preOrderItr(TreeNode root){
	        Deque<TreeNode> stack = new LinkedList<TreeNode>();
	        stack.addFirst(root);
	        while(!stack.isEmpty()){
	            root = stack.pollFirst();
	            System.out.print(root.val + " ");
	            if(root.right != null){
	                stack.addFirst(root.right);
	            }
	            if(root.left!= null){
	                stack.addFirst(root.left);
	            }
	        }
	    }
	    
	    public void postOrderItr(TreeNode root){
	        Deque<TreeNode> stack1 = new LinkedList<TreeNode>();
	        Deque<TreeNode> stack2 = new LinkedList<TreeNode>();
	        stack1.addFirst(root);
	        while(!stack1.isEmpty()){
	            root = stack1.pollFirst();
	            if(root.left != null){
	                stack1.addFirst(root.left);
	            }
	            if(root.right != null){
	                stack1.addFirst(root.right);
	            }
	            stack2.addFirst(root);
	        }
	        while(!stack2.isEmpty()){
	            System.out.print(stack2.pollFirst().val + " ");
	        }
	    }
	    
	    public void postOrderItrOneStack(TreeNode root){
	        TreeNode current = root;
	        Deque<TreeNode> stack = new LinkedList<>();
	        while(current != null || !stack.isEmpty()){
	            if(current != null){
	                stack.addFirst(current);
	                current = current.left;
	            }else{
	                TreeNode temp = stack.peek().right;
	                if (temp == null) {
	                    temp = stack.poll();
	                    System.out.print(temp.val + " ");
	                    while (!stack.isEmpty() && temp == stack.peek().right) {
	                        temp = stack.poll();
	                        System.out.print(temp.val + " ");
	                    }
	                } else {
	                    current = temp;
	                }
	            }
	        }
	    }
	
	
}
