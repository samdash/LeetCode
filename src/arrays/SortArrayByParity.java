package arrays;

import java.util.Arrays;

/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
 */
public class SortArrayByParity {

	public static void main(String[] args) {
		int[] A = {3,1,2,4};
		SortArrayByParity sap = new SortArrayByParity();
		int[] result = sap.sortArrayByParity(A);
		System.out.println(Arrays.toString(result));
	}

	public int[] sortArrayByParity(int[] A) {
        int[] arr = new int[A.length];
        int begin = 0;
        int end = A.length - 1;
        for(int i = 0;i < A.length;i++){
            //[3,1,2,4]
            if(A[i] % 2 == 0){
                arr[begin++] = A[i];
            }else{
                arr[end--] = A[i];
            }
        }
        return arr;
    }
}
