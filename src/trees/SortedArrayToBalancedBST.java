package trees;

public class SortedArrayToBalancedBST {
	 
    public static void main(String[] args) {
        int array[] = { 3, 6, 8, 23, 48, 76, 89};
        TreeNode treeRoot = createBST(array);
        inorder(treeRoot);
        System.out.println();
        preOrder(treeRoot);
    }
     
    public static TreeNode createBST(int array[]) {
 
        return createBST(array, 0, array.length-1);
    }
 
    private static TreeNode createBST(int[] array, int start, int end) {
         
        if(array == null || array.length == 0 || start > end) {
            return null;
        }
         
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(array[mid]);
         
        root.left = createBST(array, start, mid-1);
        root.right = createBST(array, mid+1, end);
         
        return root;
    }
     
    public static void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
         
        inorder(root.left);
        System.out.print(root.val + "  ");
        inorder(root.right);
    }
    
    public static void preOrder(TreeNode root) {
    	if(root == null) return ;
    	System.out.print(root.val+"  ");
    	preOrder(root.left);
    	preOrder(root.right);
    	
    }
}
 
