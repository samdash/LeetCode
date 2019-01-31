package arrays;

import java.util.Arrays;

/*
Given an array of strictly the characters 'R', 'G', and 'B', 
segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 */
public class RGB {

	public static void main(String[] args) {
		String[] data = {"G", "B", "R", "R", "B", "R", "G"};
		System.out.println("Input : "+Arrays.toString(data));
		System.out.println("Output - sort : "+Arrays.toString(arrange(data)));


	}

	public static String[] arrange(String a[]) 
    { 
        int lo = 0; 
        int hi = a.length - 1; 
        int mid = 0;
        String temp;
        while (mid <= hi) 
        { 
            switch (a[mid]) 
            { 
	            case "R": 
	            { 
	                temp   =  a[lo]; 
	                a[lo]  = a[mid]; 
	                a[mid] = temp; 
	                lo++; 
	                mid++; 
	                break; 
	            } 
	            case "G": 
	                mid++; 
	                break; 
	            case "B": 
	            { 
	                temp = a[mid]; 
	                a[mid] = a[hi]; 
	                a[hi] = temp; 
	                hi--; 
	                break; 
	            } 
            } 
            System.out.println(Arrays.toString(a));
        }
        return a;
    }
}
