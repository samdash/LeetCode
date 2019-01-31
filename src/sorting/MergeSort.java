package sorting;

import java.util.Arrays;

/*
 Repeatedly divided the data in half , sorts each half and combines the sorted halves into a sorted whole.
 The Algorithm.
 
 - Divide the list into two roughly equal halves
 - Sort the left half.
 - Sort the right half.
 - Merge the two sorted halves into one sorted list.
 
 - Often implemented recursively.
 
 RunTime : O( N log N) .
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {10,9,3,7,4,-2,0,1,22,44,12,30};
		MergeSort ms = new MergeSort();
		ms.mergeSortRecursive(arr);
		System.out.println(Arrays.toString(arr));
	}

	public void mergeSortRecursive(int[] arr) {
		// base case
		if(arr.length <= 1) return;
		// recursive case
		// - split the array in half
		int[] left =  Arrays.copyOfRange(arr, 0, arr.length/2);
		int[] right = Arrays.copyOfRange(arr, (arr.length/2), arr.length );
		// - sort the halves 
		
		mergeSortRecursive(left);
		mergeSortRecursive(right);
		
		// - merge the halves
		
		int i1 = 0; // index into the left array 
		int i2 = 0; // index into the right array
		for(int i=0;i<arr.length ;i++) {
			if(i2 >= right.length || (i1 < left.length && left[i1] < right[i2])) {
				arr[i] = left[i1];
				i1 ++;
			}else {	
				arr[i] = right[i2];
				i2++;
			}
		}
		
	}
	
	 
	
}
