package trees;

import java.util.LinkedList;

/*
Design an algorithm to encode an N-ary tree into a binary tree and decode the binary tree to get the original N-ary tree. 
An N-ary tree is a rooted tree in which each node has no more than N children. Similarly, 
a binary tree is a rooted tree in which each node has no more than 2 children.
 There is no restriction on how your encode/decode algorithm should work. 
 You just need to ensure that an N-ary tree can be encoded to a binary tree and this binary tree can be decoded to the original N-nary tree structure.

For example, you may encode the following 3-ary tree to a binary tree in this way:
 

Note that the above is just an example which might or might not work. You do not necessarily need to follow this format,
 so please be creative and come up with different approaches yourself.

 

Note:

N is in the range of [1, 1000]
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 */
public class NArrayToBinaryTree_Encode_Decode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Encodes an n-ary tree to a binary tree.
    public TreeNode encode(NArrayNode root) {
        if (root == null) {
            return null;
        }
        TreeNode result = new TreeNode(root.val);
        if (root.children.size() > 0) {
            result.left = encode(root.children.get(0));
        }
        TreeNode cur = result.left;
        for (int i = 1; i < root.children.size(); i++) {
            cur.right = encode(root.children.get(i));
            cur = cur.right;
        }
        return result;
    }

    // Decodes your binary tree to an n-ary tree.
    public NArrayNode decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        NArrayNode result = new NArrayNode(root.val, new LinkedList<>());
        TreeNode cur = root.left;
        while (cur != null) {
            result.children.add(decode(cur));
            cur = cur.right;
        }
        return result;
    }

}
