package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
Given an n-ary tree, return the preorder traversal of its nodes' values.
For example, given a 3-ary tree:

				1
			  / | \
			 3  2  4
			/ \
		   5   6

Return its preorder traversal as: [1,3,5,6,2,4].
 */
import java.util.Queue;


public class NArrayTraversals {
	
	List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {

	}
	// PRE Order
    public List<Integer> preorder(NArrayNode root) {
         if(root == null) return list;
        
        list.add(root.val);
        for(NArrayNode node: root.children)
            preorder(node);
        
        return list;
        
        
    }
    // POST Order 
    public List<Integer> postorder(NArrayNode root) {
        if(root == null) return list;
        for(NArrayNode n : root.children){
            postorder(n);
        }
        list.add(root.val);
        return list;
    }
    
    
    // LEVEL ORDER
    
    public List<List<Integer>> levelOrder(NArrayNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<NArrayNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
            	NArrayNode node = queue.poll();
                list.add(node.val);
                for (NArrayNode nei : node.children) {
                    queue.offer(nei);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
