package trees;

public class NArrayMaxDepth {

	public static void main(String[] args) {

	}

	int max  = 0;
    public int maxDepth(NArrayNode root) {
        if(root == null) return 0;
        helper(root,1);
        return max;
    }
    
    public void helper (NArrayNode root, int depth){
        if(root == null) return;
        max = Math.max(max,depth);
        for(NArrayNode n : root.children){
            helper(n,depth +1);
        }
    }
}
