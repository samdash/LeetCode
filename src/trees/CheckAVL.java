package trees;


public class CheckAVL {
	
    public boolean isAVL(TreeNode root, int min, int max) {
        if(root == null)
            return true;
        return root.val > min && root.val < max 
        		&& isAVL(root.left, min, root.val) 
        		&& isAVL(root.right, root.val, max) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }
    public int getHeight(TreeNode root){
        int leftHeight, rightHeight;
        if(root == null)
            return 0;
        else{
            leftHeight = getHeight(root.left);
            rightHeight = getHeight(root.right);
            if(leftHeight > rightHeight)
                return leftHeight + 1;
            else
                return rightHeight + 1;
        }
    }
    
    public boolean isAVL(TreeNode root){
        return isAVL(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
