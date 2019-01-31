package stanford;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("jane");
		list.add("bob");
		list.add("matt");
		list.add("sara");
		
		Subsets snl = new Subsets();
		snl.subsets(list);
	}
	
	public void subsets(List<String> list) {
		List<String> chosen = new ArrayList<String>();
		backtrack(list,chosen);
	}
	
	public void backtrack(List<String> list, List<String> chosen) {
		if(list.isEmpty()) {
			System.out.println(chosen);
		}
		else {
			// there are two choices to explore, the subset with first element, and one without it.
			String first = list.get(0);
			list.remove(0);
			chosen.add(first); 				 // choose / explore (with) "jane"
			backtrack(list,chosen);
			
			chosen.remove(chosen.size() -1); // choose explore (without) "jane"
			backtrack(list,chosen);
			list.add(0, first);				 // un-choose
		}
	}
	

}
