package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 Given a binary tree 

          1
         / \
        2   3
       / \     
      4   5    

 */
public class SerializeAndDeserializeBT {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		SerializeAndDeserializeBT bt = new SerializeAndDeserializeBT();
		String s = bt.serialize(root);
		System.out.println(s);
		
		TreeNode node = bt.deserialize(s);
		BinaryTreePaths btp = new BinaryTreePaths();
		List<String> list = btp.binaryTreePaths(node);
		System.out.println(list.toString());
	}
	
	// Encodes a tree to a single string.
    public  String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    public  void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
        } else {
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }


  // Decodes your encoded data to tree.
    public  TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q);
    }
    
    public  TreeNode deserialize(Queue<String> q) {
        String s = q.poll();
        if (s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(q);
        root.right = deserialize(q);
        return root;
    }


}
