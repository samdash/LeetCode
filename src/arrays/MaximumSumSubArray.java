package arrays;

import java.util.Arrays;

/*
 Using Kadane's Algorithm.
 */

public class MaximumSumSubArray {

	public static void main(String[] args) {
		int[] arr = {2, -8, 3, -2, 4, -10};

		int[] result = maxSumSubArray(arr);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] maxSumSubArray(int[] arr) {
		int max_so_far = arr[0];
		int max_ending_here = 0;
		int[] result = new int[2];
		
		int start=0,end=0,s=0; // keeping track of the sub array.
		
		for(int i=0;i<arr.length;i++) {
			max_ending_here = max_ending_here + arr[i];
			if(max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s ; end = i;
			}
			if(max_ending_here < 0) {
				max_ending_here = 0;
				s = i+1;
			}
		}
		
		result[0] = start;
		result[1] = end;
		
		return result;
	}
	
	 // returns [startIndex, endIndex, maxSum]
    public static int[] getMaxSumSequence(int[] a) {
        if (a == null || a.length == 0) return null;

        int start = 0, end = 0, sum = 0;
        int[] ret = {0, 0, Integer.MIN_VALUE};
        for (int i = 0; i < a.length; ++i) {
            sum += a[i];
            end = i;
            if (sum > ret[2]) {
                ret[0] = start;
                ret[1] = end;
                ret[2] = sum;
            }
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        return ret;
    }

}
