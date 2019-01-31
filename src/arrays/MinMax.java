package arrays;

import java.util.Arrays;

public class MinMax {

public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6};
		int[] value = minMax(arr);
		System.out.println(Arrays.toString(value));
		
	}

        
	// Prints max at first position, min at second position 
    // second max at third position, second min at fourth 
    // position and so on. 
    static int[] minMax(int[] arr) 
    { 
    	int n = arr.length;
        // Auxiliary array to hold modified array 
        int temp[] = new int[n]; 
      
        // Indexes of smallest and largest elements 
        // from remaining array. 
        int small=0, large=n-1; 
      
        // To indicate whether we need to copy rmaining 
        // largest or remaining smallest at next position 
        boolean switchFlag = true; 
      
        // Store result in temp[] 
        for (int i=0; i<n; i++) 
        { 
            if (switchFlag) 
                temp[i] = arr[large--]; 
            else
                temp[i] = arr[small++]; 
      
            switchFlag = !switchFlag; 
        } 
      
        // Copy temp[] to arr[] 
        arr = temp.clone(); 
		
        return arr;

    } 

}
