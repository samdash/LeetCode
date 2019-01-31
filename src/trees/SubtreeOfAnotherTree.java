package trees;

public class SubtreeOfAnotherTree {

	public static void main(String[] args) {

	}
	// check to see if sub TreeNode is subtree or root node
	public static boolean isSubtreeOfAnotherTree(TreeNode root, TreeNode sub) {
		
		if( sub == null) return true;
		if(root == null) return false;
		if(isSameTree(root,sub)) return true;
		return isSubtreeOfAnotherTree(root.left, sub) || isSubtreeOfAnotherTree(root.right, sub);
		
	}

	
	 public static boolean isSameTree(TreeNode p, TreeNode q) {
         if(p==null && q == null) return true;
         if(p == null || q == null) return false;
        return (p.val == q.val)&& isSameTree(p.left, q.left) && isSameTree(q.right,p.right);
    }
}
