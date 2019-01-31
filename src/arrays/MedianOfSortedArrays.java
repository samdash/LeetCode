package arrays;

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */
public class MedianOfSortedArrays {

	public static void main(String[] args) {

		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		MedianOfSortedArrays mosa = new MedianOfSortedArrays();
		double value = mosa.findMedianSortedArrays(nums1,nums2);
		System.out.println(value);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medianIndex;
        medianIndex = (nums1.length + nums2.length) / 2 + 1;
        int first = 0;
        int second = 0;
        int median1 = 0;
        int median2 = 0;
        while ((first + second) < medianIndex) {
            median2 = median1;
            if (first >= nums1.length) {
                median1 = nums2[second];
                second++;
            } else if (second >= nums2.length) {
                median1 = nums1[first];
                first++;
            } else if (nums1.length == 0) {
                median1 = nums2[second];
                second++;
            } else if (nums2.length == 0) {
                median1 = nums1[first];
                first++;
            } else if (nums1[first] < nums2[second]) {
                median1 = nums1[first];
                first++;
            } else {
                median1 = nums2[second];
                second++;
            }
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            return (double)median1;
        } else {
            return (double)(median1 + median2) / 2;
        }
    }
}
