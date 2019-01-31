package trees;


/*
 Example:
Given a binary tree 
Input : 

     4
   /   \
  7     2
 / \   / \
5   9 3   1

7,5,9 is the Binary Search Tree and size is 3

nodeLeft 5 will return ( T, 1, 5,5) -- > isBST = True, size is 1 , min = 5 and max =5
node Right 9 will return ( T,1,9,9) --> isBST = True , size is 1 , min = 9 and max = 9
node Root 7 will return ( T,3,5,9) --> isBST = True because , nodeLeft.max(5) is less than root.val (7) and nodeRight.min(9) > root.val (7), as per BST Properties

 */
public class LargestBSTInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(7);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(9);
		root.right.right = new TreeNode(1);
		root.right.left = new TreeNode(3);
		
		LargestBSTInBinaryTree lbt = new LargestBSTInBinaryTree();
		int value = lbt.largestBSTSubtree(root);
		System.out.println(value);
		
	}

	
	public int largestBSTSubtree(TreeNode root) {
        return largestBSTSubtreeHelper(root).size;
    }
    
    private Node largestBSTSubtreeHelper(TreeNode root) {
        if (root == null) {
            return new Node(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);//fake node for null
        }
        Node nodeLeft = largestBSTSubtreeHelper(root.left);
        Node nodeRight = largestBSTSubtreeHelper(root.right);
        if (nodeLeft.isBST && nodeRight.isBST && nodeLeft.max < root.val && nodeRight.min > root.val) {
            return new Node(true, nodeLeft.size + nodeRight.size + 1, Math.min(nodeLeft.min, root.val), Math.max(nodeRight.max, root.val));
        }
        // above we use Math.min(nodeL.min, root.val) instead of just nodeL.min is because we use Integer.MAX_VALUE 
        //for the fake null node and we need to find the true min which is root.val.
        return new Node(false, Math.max(nodeLeft.size, nodeRight.size), root.val, root.val); // leaf nodes
    }
    
    
    
}
class Node {
    boolean isBST;
    int size;
    int min;
    int max;
    Node(boolean v, int s, int min, int max) {
    	isBST = v;
        size = s;
        this.min = min;
        this.max = max;
    }
}