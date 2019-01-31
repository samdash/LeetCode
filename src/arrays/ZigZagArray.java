package arrays;

import java.util.Arrays;
/*
 zigzag properties are 
 
 if flag = 0 --> start < start +1 -- > do nothing
 if flag = 1 --> start > start +1 --> do nothing
 else 
 swap start and start +1
 
 and then switch the flag alternatively
 
 */
public class ZigZagArray {

	public static void main(String[] args) {

		int[] arr = {3,4,6,2,1,8,9};
		zigzag(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void zigzag(int[] arr) {
		boolean flag = false;
		
		int start =0;
		int end = arr.length-1;
		
		while(start < end) {
			if(!flag && arr[start] < arr[start+1]) {
				System.out.println(flag +"->"+arr[start]+" -> "+arr[start+1]);
			}else if(flag && arr[start] > arr[start+1]) {
				System.out.println(flag +"->"+arr[start]+" -> "+arr[start+1]);
			}else {
				System.out.println("swapping ->"+arr[start]+" -> "+arr[start+1]);
				swap(arr,start,start +1);
			}
			start ++;
			flag = !flag;

		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp;
		 
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


}
