package arrays;

public class ContainerWithMostWater {

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 * https://leetcode.com/problems/container-with-most-water/discuss/6100/Simple-and-clear-proofexplanation
 * 
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
which together with x-axis forms a container, such that the container contains the most water.

 */
	
	public static void main(String[] args) {
        int[] towerHeight = { 1,8,6,2,5,4,8,3,7 };
        System.out.println(maxArea(towerHeight));
	}

	/***

I've seen some "proofs" for the common O(n) solution, but I found them very confusing and lacking. 
Some even didn't explain anything but just used lots of variables and equations and were like "Tada! See?". I think mine makes more sense:

Idea / Proof:

The widest container (using first and last line) is a good candidate, because of its width. Its water level is the height of the smaller one of first and last line.
All other containers are less wide and thus would need a higher water level in order to hold more water.
The smaller one of first and last line doesn't support a higher water level and can thus be safely removed from further consideration.

Variables left and right define the container under consideration. We initialize them to first and last line, meaning the widest container. 
Variable water will keep track of the highest amount of water we managed so far. We compute right - left, the width of the current container, 
and min(height[left], height[right]), the water level that this container can support. 
Multiply them to get how much water this container can hold, and update water accordingly. 
Next remove the smaller one of the two lines from consideration, as justified above in "Idea / Proof". 
Continue until there is nothing left to consider, then return the result
*/
	
	
	
	public static int maxArea(int[] height) {
        int maxarea = 0, left = 0, right = height.length - 1;
        while (left < right) {
        	System.out.print("left : "+left+" right: "+right+" ");
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * (right - left));
            System.out.println("left height: "+height[left]+" right height: "+height[right]+" and maxarea = "+maxarea);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxarea;
    }
	

}
