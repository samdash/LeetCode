package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstSecondThirdSmallest {

	public static void main(String[] args) {
		
//		Set<Integer> set = new HashSet<>();
//		set.add(3);
//		set.add(1);
//		set.add(5);
//		set.add(9);
//		set.add(11);

		Set<Integer> ints = new HashSet<>(Arrays.asList(9,4,3,8,1));
		
		FirstSecondThirdSmallest ts = new FirstSecondThirdSmallest();
		int result = ts.thirdSmallest(ints,3);
		System.out.println(result);
		
		ts.firstSecondThirdSmallest(ints);
	}

	public  int thirdSmallest(Set<Integer> ints,int k ) {
				
		int[] temp = ints.stream()
				.mapToInt(Integer::intValue)
				.toArray();
		Arrays.sort(temp);
		return temp[k-1];
		
	}
	
	
	public void firstSecondThirdSmallest(Set<Integer> ints) {
		Integer[] temp = ints.toArray(new Integer[] {}); // already sorted
		int smallest = temp[0];
		for(int i=1;i<temp.length;i++) {
			if(temp[i] < smallest) {
				smallest = temp[i];
			}
		}
		
		int secondSmallest = temp[0];
		
		for(int i=1;i<temp.length;i++) {
			if(temp[i] < secondSmallest && temp[i] > smallest || secondSmallest == smallest) {
				secondSmallest = temp[i];
			}
		}
		
		int thirdSmallest = temp[0];
		
		for(int i=1;i<temp.length;i++) {
			if(temp[i] < thirdSmallest && temp[i] > secondSmallest || thirdSmallest <= secondSmallest ) {
				thirdSmallest = temp[i];
			}
		}
		
		System.out.println("smallest --> "+smallest);
		System.out.println("2nd smallest --> "+secondSmallest);
		System.out.println("3rd smallest --> "+thirdSmallest);

		
	}
	
}
