package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumPairs {

	public static void main(String[] args) {
		int[]a = {2,3,4,6,7};
		int k = 7;
		List<List<Integer>> l = new ArrayList<>();
		helper( a, k,new ArrayList<Integer>() ,l,0);
		System.out.println(l);
		helperBinary(a,k);
	}
	
	public static void helper(int[] a , int target,List<Integer> chosen, List<List<Integer>> list, int start){
		indent(chosen.size());
		String temp = "backtrack(\"chosen-> "+chosen+"\",\" start-> "+start+"\",\" target-> "+target+"\")";
		System.out.println(temp);
		// base case:
		if( target < 0) return;
		if( target == 0 ) {
			list.add(new ArrayList<>(chosen));
		}
		for(int i=start;i< a.length;i++) {
			chosen.add(a[i]);
			helper(a,target - a[i],chosen,list,i+1);
			chosen.remove(chosen.size() -1);
		}
	}
	
	public static void indent(int n) {
		for(int i=0;i<n;i++)System.out.print("    ");
	}
	
	public static void helperBinary( int [] nums, int target) {
		int left = 0;
		int right = nums.length -1 ;
		Arrays.sort(nums);
		while( left < right) {
			int sum = nums[left]+nums[right];
			if( sum == target ) {
				System.out.println(" "+nums[left]+" "+nums[right]);
				left++;
				right-- ;
			}else if( sum < target) {
				left ++;
			}else if( sum > target) {
				right --;
			}
		}
	}
	
	
	
	

}
