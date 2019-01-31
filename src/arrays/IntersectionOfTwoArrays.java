package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
 Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.

 */
public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		
		IntersectionOfTwoArrays i2 = new IntersectionOfTwoArrays();
		System.out.println(Arrays.toString(i2.intersection(nums1, nums2)));
		System.out.println(Arrays.toString(i2.intersectionUsingBinarySearch(nums1, nums2)));
	}
	
	
	
	public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0)
            return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1=0;
        int p2=0;
        List<Integer> res=new ArrayList<Integer>();
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1]==nums2[p2]){
                res.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1]<nums2[p2])
                p1++;
            else 
                p2++;
        }
        int[] t=new int[res.size()];
        for(int i=0;i<res.size();i++)
            t[i]=res.get(i);
            
        return t;
    }
	
	/*** BELOW 2 Methods were not accepted in LEETCODE , was not working in few scenarios ******/
	
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
	
	
	
	public int[] intersectionUsingBinarySearch(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }
    
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
