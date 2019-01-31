package arrays;

public class FindMissingNumber {

	public static void main(String[] args) {
		int[] arr = {1,2,3,5,6,7,8};
		System.out.println(missing(arr));
		System.out.println(missingXOR(arr));

	}
	
	public static int missing(int[] arr) {
		
		int sum = 0;
		int sumRange = 0;
		int n = arr.length;
		
		for(int i=1;i<=n+1;i++) { // get range from 1 to 8 ( length of array)
			sumRange += i;
			System.out.println(sumRange);
		}
		
		for(int i = 0; i<arr.length;i++) {
			sum+= arr[i];
		}
		
		int missing = sumRange - sum;
		return missing;
	}
	
	// doing XOR of the range + XOR of array elements, so basically doing XOR of everything
	// to do this ,you need to store the range + actual array element
	// range = arr.length count ( 1..length of array) 
	
	public static int missingXOR(int[] arr) {
		
		int totalLength = (arr.length * 2) +1; // +1 is because one number is missing
		int[] total = new int[totalLength]; 
		int length = arr.length;
		int k = 0;
		for(int i=1;i<=length+1;i++){ // range from 1 to 8
			total[k] = i;
			k++;
		}
		
		for(int i=0;i<arr.length;i++) {
			total[k] = arr[i];
			k++;
		}
 		
		int result = 0;
		for(int i=0;i<total.length;i++) {
			result= result^total[i];
		}
		
		return result;
		
	}

}
