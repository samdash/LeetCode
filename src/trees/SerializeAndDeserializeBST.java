package trees;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
 or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

Example:
Given a binary tree 

          5
         / \
        4   6
       / \     
      2   3    
      


 */
public class SerializeAndDeserializeBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		
		SerializeAndDeserializeBST sbt = new SerializeAndDeserializeBST();
		String s = sbt.serialize(root);
		//s = s.substring(0, s.length() -1); // remove last ","
		System.out.println(s);
		
		TreeNode node = sbt.deserialize(s);
		BinaryTreePaths p = new BinaryTreePaths();
		List<String> list = p.binaryTreePaths(node);
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
