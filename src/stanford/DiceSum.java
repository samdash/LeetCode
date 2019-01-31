package stanford;

import java.util.ArrayList;
import java.util.List;

public class DiceSum {

	public static void main(String[] args) {
		DiceSum ds = new DiceSum();
		ds.diceSum(3, 7);

	}

	public void diceSum(int dice, int target) {
		List<Integer> chosen = new ArrayList<Integer>();
		backtrack(dice,target,chosen);
	}
	
	public void backtrack(int dice,int target, List<Integer> chosen) {

		if(dice == 0) {
			if(target == 0) {
				System.out.println(chosen);
			}
		}else { // to optimize we can reduce the call's by saying // else if( target >= dice *1 && target <= dice *6) // this way we can avoid some of the -ve values
			// I will handle 1 die; 
			// try all possible values ( 1- 6) to see if they can work
			for(int i=1;i<=6;i++) {
				// choose i
				chosen.add(i);
				// explore what could follow next
				backtrack(dice -1,target - i,chosen );
				// un-choose
				chosen.remove(chosen.size() -1);
			}
		}
	}
}
