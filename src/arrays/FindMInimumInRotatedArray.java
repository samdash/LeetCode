package arrays;

public class FindMInimumInRotatedArray {

	public static void main(String[] args) {
		int[] arr = {3,4,5,0,1,2};

		findMin(arr);
	}
	
	public static int findMin(int[] arr) {
		
		// cover base conditions
		if(arr.length == 1) return arr[0];
		
		int left =0, right = arr.length -1, min =0;
		
		while(right >= left) {
			int mid = left + ( right -left)/2; // mid = 5 
			System.out.println(arr[mid]);
			if(arr[mid] > arr[mid+1]) { // is 5 > 0
				return arr[mid +1];
			}
			if(arr[mid -1] > arr[mid]) { // is 4 > 5
				return arr[mid];
			}
			if(arr[mid] > arr[0]) { // is 5 > 3
				left = mid +1;
			}else {
				right = mid -1;
			}
		}
		
		return -1;
	}

}
