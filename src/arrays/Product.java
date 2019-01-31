package arrays;

import java.util.ArrayList;
import java.util.List;

/***

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers
in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * 
 * @author samaraarkotti
 *
 */

public class Product {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		List<Integer> myList = new ArrayList<Integer>();
		int count = 0;
		for (int i=0;i< array.length;i++) {
			int value = getProduct(array,count);
			myList.add(value);
			count ++;
					
		}
		
		System.out.println(myList);
		
	}
	
	public static int getProduct(int[] array, int count) {
		
		int sum = 1;
		for ( int j=0;j<array.length;j++) {
			if ( j == count ) {
				continue;
			}
			sum = sum * array[j];
			
		}
		return sum;
	}

}
