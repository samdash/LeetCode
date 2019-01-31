package arrays;

import java.util.HashMap;
/*
Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:

Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
Follow up:
What if the input numbers come in one by one as an infinite stream? In other words, 
you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
 */
public class findMaxConsecutiveOnesII {

public static void main(String[]args){
	int count = 0;
    int zero = 0;
    int max = 0;
    int []nums = {1,0,1,1,0,0,1,1,1,1,1};//{1,0,1,1,0,1,1,1,0,1};
    HashMap<Integer,Integer> hashmap = new HashMap<Integer, Integer>();
    
    for(int i = 0; i < nums.length; i++){
        if(nums[i] == 1){
            count = count + 1;
            System.out.println("Encountered ONE at index " + i + " and the COUNT is incremented to: " + count);
        }
        else if(nums[i] == 0 && zero >= 1 && hashmap.containsKey(nums[i])){
            max = Math.max(max, count);
            int temp = hashmap.get(nums[i]);
            count = i - temp; 
            hashmap.put(nums[i],i);
            zero = 1;
            System.out.println("Encountered a ZERO at " + i + "th index. " + "COUNT changed to: " + count + ". MAX is now :" + max + ".");
        }
        else if(nums[i] == 0 && zero == 0) {
            count = count + 1;
            zero = zero + 1;
            hashmap.put(nums[i], i);
            System.out.println("Encountered FIRST ZERO, at " + i + "th index. " + "COUNT incremented to: " + count + " and ZERO incremented to: " + zero);
        }
    }
    int finalNum = Math.max(max,count);
    System.out.println(finalNum);
}
}