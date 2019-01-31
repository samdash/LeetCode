package arrays;

public class FibonacciWithMemoization {

	public static void main(String[] args) {
		int n = 5;
		FibonacciWithMemoization f = new FibonacciWithMemoization();
		System.out.println(f.fib(n, new int[n+1]));

	}
	
	public int fib(int n, int[] memo) {
		if(n==0 || n ==1) return 1;
		else if(memo[0] ==0){
			memo[n] = fib(n-1,memo)+ fib(n-2,memo);
		}
		return memo[n];
	}

}
