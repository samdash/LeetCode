package arrays;

public class FindMissingNumberII {

	public static void main(String[] args) {
		int[] big = {4,8,12,9,3};
		int[] small = {4,8,9,3};

		FindMissingNumberII fm = new FindMissingNumberII();
		int result = fm.findMissingSimple(big, small);
		System.out.println(result);
		result = fm.findMissing(big, small);
		System.out.println(result);
	}

	// this is ok for small numbers , however if you have very big number and if you add them ,
	// there might be an integer overflow , refer to 
	public int findMissingSimple(int[] big, int[] small) {
		return sumArray(big) - sumArray(small);
	}
	
	
	public int findMissing(int[] big, int[] small) {
		int h1 =0,h2=0,sum=0;
		while(h1 < big.length && h2<small.length) {
			if(sum < 0) {
				sum+= big[h1];
				h1++;
			}else {
				sum -= small[h2];
				h2++;
			}
		}
		while(h1<big.length) {
			sum+= big[h1];
			h1++;
		}
		while(h2<small.length) {
			sum-= small[h2];
			h2++;
		}
		
		return sum;
	}
	
	
	public int sumArray(int[] arr) {
		int sum = 0;
		for(int a : arr) {
			sum+= a;
		}
		
		return sum;
	}
}
