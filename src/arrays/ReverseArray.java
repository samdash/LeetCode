package arrays;

import java.util.Arrays;
// reverse array without using extra space
public class ReverseArray {

	public static void main(String[] args) {
		int [] nums = {1,2,3,4,5};
		reverse(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void reverse(int[] nums) {
		int s = 0;
		int e = nums.length -1 ;
		
		while(s < e){
			swap(nums,s,e);
			s++;
			e--;
		}
		
	}
	
	private static void swap(int[] nums, int s, int e) {
		int temp = nums[s];
		nums[s] = nums[e];
		nums[e] = temp;
	}

}
