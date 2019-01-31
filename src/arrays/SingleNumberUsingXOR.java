package arrays;


/*
 Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */
public class SingleNumberUsingXOR {

	public static void main(String[] args) {
		int[] nums = {3,1,2,1,2};
		System.out.println(singleNumber(nums));

	}
	
	// every number when XOR'd with itself give you zero. 1 ^1 ^2 ^2 ^3 = 3 as 1^1 =0, 2^2 ^ 0 and 0 ^ 0 ^ 3 = 3
	public static int singleNumber(int[] nums) {
	    int result = 0;
	    for(int i : nums) {
	        result = result ^ i;
	        System.out.println("i: "+i+" result:"+result);
	    }
	    return result;
	}
	
	
	
}
