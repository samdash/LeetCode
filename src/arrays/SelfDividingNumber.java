package arrays;

import java.util.ArrayList;
import java.util.List;
/*
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:

Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.

 */
public class SelfDividingNumber {

	public static void main(String[] args) {

		SelfDividingNumber sdn = new SelfDividingNumber();
		List<Integer> list = sdn.selfDividingNumbers(1, 22);
		System.out.println(list);
		
	}

	public List<Integer> selfDividingNumbers(int left, int right) {
	     
        List<Integer> ans = new ArrayList<Integer>();

        for(int i=left; i<=right ; i++){
            if(isSelfDividingNumber(i))
                ans.add(i);
        }
        return ans;
    }
    
    
    public boolean isSelfDividingNumber(int num){
    	int temp = num;        
        while (temp != 0) {
            int remainder = temp % 10;
            if (remainder == 0) {
                return false;
            } else {
                if (num % remainder != 0 ) {
                    return false;
                } 
            }
            temp = temp / 10;
        }
        return true;   
    }
}
