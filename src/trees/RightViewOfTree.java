package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*

Explanation here : https://algorithms.tutorialhorizon.com/print-right-view-of-a-given-binary-tree/
 
Method 1 :

Traverse the tree from right to left
Print the first node you encounter
Take two variables , currentLevel=0 and nextLevel=1
As soon as you change level , change the currentLevel = nextLevel
Print only when current level<nextLevel so this way you will print only the first element
For rest of the nodes on the the level currentLevel and nextLevel are equal so it wont print

Method 2:
Do the Level order traversal in reverse and print the first node value


 
Example:
Given a binary tree 

         1  
        / \ 
       2   3 
      / \     
     4   5    
     

*/

public class RightViewOfTree {
	public static int index = 0;

	public static int currentLevel =0;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		RightViewOfTree rt  = new RightViewOfTree();
		System.out.print("Recursive Method: ");
		rt.rightViewRecur(root,1);			
		System.out.print("\nLevelOrder Recursive: ");
		rt.usingLevelOrder(root);
	}
	
	
	
	public  void usingLevelOrder(TreeNode root) {
        HashMap<Integer,Integer> ht = new HashMap<Integer,Integer>();
		ht = levelOrder( root, 0,ht);
		System.out.println(ht.values());

	}
	public  HashMap<Integer,Integer> levelOrder(TreeNode root, int level,HashMap<Integer,Integer> ht) {
		if(root == null) {
            return new HashMap<Integer,Integer>();
        }
         
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            //System.out.print(node.val + " ");
            if(!ht.containsKey(level))
            	ht.put(level, node.val);  

            levelOrder(root.right,level +1,ht);// doing reverse level order
            levelOrder(root.left,level +1, ht);

        }
        
        return ht;
	}
	
	public void rightViewRecur(TreeNode root, int nextLevel){
		if(root==null) {
			return;
		}
		if(currentLevel<nextLevel){
			System.out.print ("  " + root.val);
			currentLevel = nextLevel;
		}
		rightViewRecur(root.right,nextLevel+1);
		rightViewRecur(root.left,nextLevel+1);
	}

}
