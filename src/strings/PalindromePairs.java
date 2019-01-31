package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {

	public static void main(String[] args) {

		String[] words = {"abcd","dcba","lls","s","sssll"};
		String[] words1 = {"a",""};
		String[] words2 = {"a","b","c","ab","ac","aa"};
		
		PalindromePairs pp = new PalindromePairs();
		List<List<Integer>> list = pp.palindromePairs(words);
		for(int i=0;i< list.size();i++) {
			List<Integer> l = list.get(i);
			System.out.println(l.toString());
			 
		}
	}

	public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[words.length];
        
        for(int i = 0; i < words.length; i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            for(int j = 0; j < words.length; j++) {
                if(!visited[j] && isPal(words[i], words[j])) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    res.add(tmp);
                }    
            }
        }
        return res;
    }
    
    boolean isPal(String s1, String s2) {
        String tmp = s1 + s2;
        int i = 0, j = tmp.length() - 1;
        while(i < j) {
            if(tmp.charAt(i) != tmp.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
}
