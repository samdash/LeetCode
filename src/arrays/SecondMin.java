package arrays;

public class SecondMin {

	public static void main(String[] args) {

		int[] arr = {2,3,0,6};
		System.out.println("min is --> "+getMin(arr));
		System.out.println("second min is -->"+ getSecondMin(arr));
		
	}
	// in unsorted array this is the best way to do this.
	public static int getMin(int[] arr) {
		int min = arr[0];
		for(int i=0;i< arr.length;i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		
		return min;
	}

	
	
	public static int getSecondMin(int[] arr) {
		int min = arr[0];
		int min2 = arr[1];
		
		for(int i=0;i< arr.length;i++) {
			if(arr[i] < min) {
				min2 = min;
				min = arr[i];
			}else if( arr[i] < min2) {
				min2 = arr[i];
			}
		}
		
		return min2;
	}
}
