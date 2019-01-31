package arrays;

public class NumberOccuringOddTimesXOR {

	public static void main(String[] args) {
		int[] arr= {1,1,2,2,3,3,3,4,4,5,5};
		
		int value = occuringOddTimes(arr);
		System.out.println(value);
	}
	// XOR of same elements will result in 0 ; eg 2 ^ 2 = 0 or 1 ^ 1 =0
	public static int occuringOddTimes(int[] arr) {
		
		int result= 0;
		for(int i=0;i< arr.length;i++) {
			result = result ^ arr[i];
		}
		
		return result;
	}

}
