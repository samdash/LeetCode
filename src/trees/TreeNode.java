package trees;

import static helpers.Printer.*;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.val = data;
		left = null;
		right = null;
	}
	
	
	public String toString() {
        return String.valueOf(val);
    }

    public static void printTree(TreeNode n) {
        if (n == null) return;
        println(n.val);
        printTree(n.left, 0, true);
        printTree(n.right, 0, false);
    }

    private static void printTree(TreeNode n, int level, boolean isLeft) {
        if (n == null) return;
        for (int i = 0; i < level; ++i) print("  ");
        if (isLeft)
            println("/- " + n.val);
        else
            println("\\- " + n.val);
        printTree(n.left, level + 1, true);
        printTree(n.right, level + 1, false);
    }
}