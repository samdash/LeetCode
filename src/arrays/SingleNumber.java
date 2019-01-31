package arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.
For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.
 */


public class SingleNumber {

	public static void main(String[] args) {
		int[] A = {6, 2, 3, 3, 3, 6, 6};
		System.out.println(singleNumber(A));
		System.out.println(usingHashMap(A));
	}
	public static int singleNumber(int[] A) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < A.length; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        twos = (twos ^ A[i]) & ~ones;
	    }
	    return ones;
	}
	/*
	Say arr[] = {6, 6, 6, 3}
	
	1 1 0
	1 1 0
	1 1 0
	0 1 1
	__________+
	3 4 1
	
	Now modulus with 3
	
	3mod3  4mod3 1mod3 => 0 1 1 => 3 element appearing once.
	
	 */
	public static void find (int [] arrA){
        int singleElement =0;
        for (int i = 0; i <32 ; i++) { //this is for calculating for every position in 32 bit integer
            int y = (1 << i);
            int tempSum = 0;
            for (int j = 0; j <arrA.length ; j++) {
                if((arrA[j] & y)>=1) //if that particular bit is set for the ith position, add 1 to sum (w.r.t that bit)
                    tempSum = tempSum +1;
            }
            //if bits are not multiple of 3 then that bit belongs to the element appearing single time
            if((tempSum%3)==1) {
                singleElement = singleElement | y;
            }
        }
        System.out.println("Element appearing once is: " + singleElement);
    }
	
	// not efficient.
	public static int usingHashMap(int[] B) {
		int result = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
		for(int i=0; i<B.length;i++){ 
			if(hm.containsKey(B[i])){ 
				hm.put(B[i], hm.get(B[i])+1); 
			}else{ 
				hm.put(B[i],1); 
			} 
		} 
		for(Map.Entry<Integer, Integer> m : hm.entrySet()) {
			int key = m.getKey();
			int value = m.getValue();
			if(value ==1) {
				result = key;
				break;
			}
		}
		return result;
	}
}
