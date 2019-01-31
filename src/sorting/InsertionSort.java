package sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {10,9,3,7,4,-2,0,1,22,44,12,30};
		InsertionSort is = new InsertionSort();
		is.insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void insertionSort(int[] arr) {
		for( int i=1;i<arr.length;i++) {
			int temp = arr[i];
			int j = i;
			while(j>=1 && arr[j-1] > temp) {
				arr[j] = arr[j-1];//swap neighbors
				j--;
			}
			arr[j] = temp;
		}
	}

}
