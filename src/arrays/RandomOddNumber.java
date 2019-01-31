package arrays;

import java.util.Random;

public class RandomOddNumber {

    public static void main(String args[] ) throws Exception {
        int[] arr = {2,1,4,6,3, 7};
        int[] arr1 = {2,2,2,6,2, 2};

        int value = getRandomOdd(arr);
        System.out.println(value);
    }
    
    public static int getRandomOdd(int [] arr) {
    	
    	while(true) {
    		int ran = new Random().nextInt(arr.length);
        	if(arr[ran]%2 !=0) { 
        		 return arr[ran];
        	}
    	}
    }
    
    
    /// wrong , always picks first left or the last one and not the random one.
    
    public static int getRandomFromArray(int[] arr){
        if(arr.length == 0) return Integer.MAX_VALUE;
        int left =0, right = arr.length -1;
        while(left < right){
            if(arr[left] %2 != 0 && left < right) return arr[left];
            else left++;
            if(arr[right] %2 != 0 && left < right) return arr[right];
            else right --;
        }
        return -1;
    }

}
