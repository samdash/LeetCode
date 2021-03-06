package arrays;

import java.util.Arrays;

/*
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/
public class MoveZeros {

	public static void main(String[] args) {
		int[] arr = {0,1,0,3,12};
		moveZeros(arr);
		System.out.println(Arrays.toString(arr));
	}

	 public static void moveZeros(int[] nums) {
	        int count = 0,k=0;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i] != 0) {
	                nums[k] = nums[i];
	                    k++;
	            }else{
	                count++;
	            }
	        }
	        
	        for(int j=0;j<count;j++){
	            nums[k] = 0;
	            k++;
	        }
	        
	    }
}
