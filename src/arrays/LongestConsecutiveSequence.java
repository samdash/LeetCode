package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
		int result = longestConsecutiveII(nums);
		System.out.println(result);
	}

	/*
We will use HashMap. The key thing is to keep track of the sequence length and store that in the boundary points of the sequence. 
For example, as a result, for sequence {1, 2, 3, 4, 5}, map.get(1) and map.get(5) should both return 5.

Whenever a new element n is inserted into the map, do two things:

See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n. 
Variables left and right will be the length of those two sequences, while 0 means there is no sequence and n will be the boundary point later. 
Store (left + right + 1) as the associated value to key n into the map.
Use left and right to locate the other end of the sequences to the left and right of n respectively, and replace the value with the new length.
Everything inside the for loop is O(1) so the total time is O(n).
	 */
	
	
	public int longestConsecutiveSequence(int[] num) {
	    int res = 0;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int n : num) {
	        if (!map.containsKey(n)) {
	            int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
	            int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
	            // sum: length of the sequence n is in
	            int sum = left + right + 1;
	            map.put(n, sum);
	            
	            // keep track of the max length 
	            res = Math.max(res, sum);
	            
	            // extend the length to the boundary(s)
	            // of the sequence
	            // will do nothing if n has no neighbors
	            map.put(n - left, sum);
	            map.put(n + right, sum);
	        }
	        else {
	            // duplicates
	            continue;
	        }
	    }
	    return res;
	}
	
	
	public int longestConsecutiveSet(int[] nums) {
		  int max = 0;
		  
		  Set<Integer> set = new HashSet<Integer>();
		  for (int i = 0; i < nums.length; i++) {
		    set.add(nums[i]);
		  }
		  
		  for (int i = 0; i < nums.length; i++) {
		    int count = 1;
		    
		    // look left
		    int num = nums[i];
		    while (set.contains(--num)) {
		      count++;
		      set.remove(num);
		    }
		    
		    // look right
		    num = nums[i];
		    while (set.contains(++num)) {
		      count++;
		      set.remove(num);
		    }
		    
		    max = Math.max(max, count);
		  }
		  
		  return max;
		}
	
	
	public static int longestConsecutiveII(int[] nums) 
    {
        if(nums == null || nums.length == 0)
            return 0;
        int count = 1;
        int result = 1;
        Arrays.sort(nums);
        for(int i = 0 ; i<nums.length-1 ; i++)
        {
           if(nums[i+1] == nums[i]+1) 
           {
               count++;
               result = Math.max(count,result);
           }
            else if(nums[i+1] == nums[i]) 
                continue;
            else
                count=1;
        }
        return result;
    }
	
	
	public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);//O(nlgn);
        int curr = nums[0];
        int sum = 1;
        int ans = 1;
        for(int i = 1;i< nums.length;i++){
            if(nums[i] == nums[i - 1]) continue;
            if(nums[i] == curr + 1){
                curr++;
                sum++;
                ans = Math.max(ans,sum);
            }else{
                curr = nums[i];
                sum = 1;
            }
        }
        return ans;
    }

}
