package stacks;

import java.util.Arrays;
import java.util.Stack;

/* 
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. 
If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
*/

public class DailyTemparatures {

	public static void main(String[] args) {
		DailyTemparatures d = new DailyTemparatures();
		int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
		System.out.println(Arrays.toString(d.dailyTemperatures(t)));

	}

	 
/*
 i = 0 : 
 	stack.push(0) 
 i=1;
 	T[i] = 74 , T[stack.peek()] = T[0] == 73 
 	74 > 73 -- yes 
 		idx = stack.pop == 0
 		ret[0] = 1-0 == 1
 		so ret[0] = 1 -- > 1 day
  
 */
    public int[] dailyTemperatures(int[] T) {
    	Stack<Integer> stack = new Stack<>();
	    int[] ret = new int[T.length];
	    for(int i = 0; i < T.length; i++) {
	        while(!stack.isEmpty() && T[i] > T[stack.peek()]) { // is 74 > 73 
	            int idx = stack.pop(); // pop the 73 index which is 0
	            ret[idx] = i - idx; // 1 - 0 = 1
	        }
	        stack.push(i);
	    }
	    return ret;
    }
}
