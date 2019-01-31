package sorting;

import java.util.Arrays;

/*
Orders a list of value by repeatedly putting the smallest or largest unplaces values into its final position.
The Algorithm:
Look through the list to find the smallest values 
Swap it so that it is at index 0
Look through the list to find the second - smallest value.
swap it so that it is at index 1

Repeat until all values are in their proper places

TimeComplexity : O(n square )
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {10,9,3,7,4,-2,0,1,22,44,12,30};
		SelectionSort ss = new SelectionSort();
		ss.selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void selectionSort(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			int minIndex = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr,i,minIndex);
		}
	}

	public void swap(int[] arr, int i, int minIndex) {
		int temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = temp;
	}
}
