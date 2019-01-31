package arrays;

public class TrapRainWater {

	public static void main(String[] args) {
		int[] arr = {1,0,3,1,0,1,3,1,0,1};
		System.out.println(trap(arr));
	}
	
	
	public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int max = 0;
        while(left <= right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax < rightMax){
                max += leftMax - height[left];
                left++;
            } else {
                max += rightMax - height[right];
                right--;
            }
        }
        return max;
    }
	
	public static int trapI(int[] arr) {
		
		int leftMax =0,rightMax = 0,totalWater =0;
		
		for(int i=0;i<arr.length;i++) {
			
			leftMax = Math.max(arr[i],getLeftMax(arr,i));
			rightMax = Math.max(arr[i], getRightMax(arr,i));
			
			int min = Math.min(leftMax, rightMax);
			totalWater += min - arr[i];// get min height minus height of the blokc( arr[i] )
		}
		
		return totalWater;
	}
	
	private static int getLeftMax(int[]arr, int position) {
		int max = Integer.MIN_VALUE;
		for(int i=0;i<position;i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	private static int getRightMax(int[]arr, int position) {
		int max = Integer.MIN_VALUE;
		
		for(int i = position;i<arr.length-1; i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

}
