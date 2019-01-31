package trees;

/*
 Example:
Given a binary tree check to see if node is present with data x

          1
         / \
        2   3
       / \     
      4   5    
      
Output : is 5 present ? true

 */
public class IsPresent {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		IsPresent ip = new IsPresent();
		System.out.println(ip.isPresent(root, 5));
		System.out.println(ip.isPresent(root, 3));

	}
	
	public int isPresent(TreeNode root, int val){
	    if(helper(root,val)) return 1;
	    else return 0;
	}
	
	public boolean helper(TreeNode root, int val) {
		if( root == null) return false;
		
        if(root.val == val) return true;
        else{
            return helper(root.left,val)|| helper(root.right,val);
        }
	}

}
