package arrays;

import java.util.Arrays;

/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
public class MergeTwoSortedArrays {

	public static void main(String[] args) {

		int[] A = {1,3,5,6,7,9};
		int[] B = {2,4,8,10,11,12,16};
		int m = 3;
		int n = 3;
		System.out.println(Arrays.toString(mergeSortedArray(A, B)));

//		merge(A,m,B,n);
//		System.out.println(Arrays.toString(A));  
		
		
	}
	public static void merge(int[] A, int m, int[]B, int n) {
		while(n>0) A[m+n-1] = (m==0|| B[n-1] > A[m-1]) ? B[--n] : A[--m];
 		
	}

	public static int[] mergeSortedArray(int[]A,int[]B) {
		int s1 = A.length;
		int s2 = B.length;
		int[] out = new int[s1 +s2]; 

		int k =0;
		int a = 0;
		int b = 0;
		
		while(a < s1 && b<s2) {
			if(A[a] < B[b]) {
				out[k] = A[a];
				a++;k++;
			}else {
				out[k] = B[b];
				b++;k++;
			}
		}
		// remaining elements
		while(a < s1) 
			out[k++] = A[a++];
		while(b <s2)
			out[k++] = B[b++];
		
		return out;
	}
	
}
