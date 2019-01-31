package trees;

import java.util.ArrayList;
import java.util.List;


public class GenerateBSTs {
	
	public static void main(String[] args) {
		GenerateBSTs gts = new GenerateBSTs();
		List<TreeNode> list = gts.generateTrees(5);
		System.out.println(list.size()); // to Verify refer the count check CountBSTs class
	}
	
    public ArrayList<TreeNode> generateTrees(int n) {
        if(n == 0) return generateTrees(1, 0);
        return generateTrees(1, n);
        
    }
    public ArrayList<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> subTrees = new ArrayList<TreeNode>();
        if(start > end){
            subTrees.add(null);
            return subTrees;
        }          
        for(int i = start; i <= end; i++){
            for(TreeNode left : generateTrees(start, i - 1)){
                for(TreeNode right : generateTrees(i + 1, end)){
                	TreeNode aTree = new TreeNode(i);
                    aTree.left = left;
                    aTree.right = right;
                    subTrees.add(aTree);
                }
            }
        }
        return subTrees;
    } 
}
