package arrays;

public class CompleteCycleInCircularArray {

	public static void main(String[] args) {

		int[] arr = {2,2,-1};
		System.out.println(fun(arr));
	}

	public static boolean fun(int[] arr) {
	    final int n = arr.length;

	    int index = 0;  // starting index, the value does not matter if there is indeed a complete cycle
	    for(int i = 0; i < n; i++) {  // at most n steps
	      // in Java, -b < a % b < b but 0 < (a % b + b) % b < b
	      index = ((index + arr[index]) % n + n) % n; // 
	      System.out.println(index);
	      if(index == 0 && i < n - 1) {  // subcyle
	        return false;
	      }
	    }
	    return index == 0;  // are we back to the original cell after n steps
	  }
}
