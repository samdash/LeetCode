package arrays;

import java.util.Arrays;

/*
Input : [3,4,20,6,15,2,1,7]
Replace Every Element with Next greatest element.

Output : [ 20,20,20,15,15,7,7,7]
 */

public class NextGreatestElement {

	public static void main(String[] args) {

		int[] arr = {3,4,20,6,15,2,1,7};
		nextGreatestElement(arr);
	}
	
	public static void nextGreatestElement(int[] arr) {
		
		int n = arr.length-1;
		int max_from_right = arr[n]; // let's make the last element as max
		
		for(int i=n-1;i>=0 ;i--) {
			if( max_from_right > arr[i]) {
				arr[i] = max_from_right;
			}else {
				max_from_right = arr[i];
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
