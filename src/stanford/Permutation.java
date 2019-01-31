package stanford;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		Permutation p = new Permutation();
		p.permute(list);
	}

	
	public void permute(List<String> list) {
		List<String> chosen = new ArrayList<String>();
	//	backtrack(list,chosen);
		backtrack(list,chosen);
	}

	public void backtrack(List<String> list, List<String> chosen) {
		indent(chosen.size());
		String temp = "permute list= (\""+list+"\",\" chosen= "+chosen+"\")";
		System.out.println(temp);

		if(list.isEmpty()) {
			System.out.println(chosen);
		}else {
			for(int i=0;i<list.size();i++) {
				// - choose 
				String s = list.get(i);
				chosen.add(s); // choose A
				list.remove(i); // now list contains B and C
				// explore 
				backtrack(list,chosen);
				// -- un-choose
				chosen.remove(chosen.size() -1);
				list.add(i,s);
			}
		}
	}
	
	
	public void backtrackII(List<String> list, List<String> chosen) {
		indent(chosen.size());
		String temp = "permute list= (\""+list+"\",\" chosen= "+chosen+"\")";
		System.out.println(temp);

		if(list.size() == chosen.size()) {
			System.out.println(chosen);
		}else {
			for(int i=0;i<list.size();i++) {
				// - choose 
				String s = list.get(i);
				if(chosen.contains(s)) continue;
				chosen.add(s); // choose A
				// explore 
				backtrackII(list,chosen);
				// -- un-choose
				chosen.remove(chosen.size() -1);
			}
		}
	}
	
	
	public static void indent(int n) {
		for(int i=0;i<n;i++)System.out.print("    ");
	}

}
