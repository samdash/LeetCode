package sorting;
import java.util.ArrayList;
import java.util.List;

public class quickSort {

	public static void main(String[] s ) {
		List<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(10);
		array.add(2);
		array.add(4);
		array.add(9);
		array.add(13);
		array.add(33);
		
		List<Integer> result = quicksort(array);
		System.out.println(result);
		
	}
	public static List<Integer> quicksort(List<Integer> numbers) {
		if (numbers.size() < 2) {
			return numbers; 
		}
		final Integer pivot  = numbers.get(0); // let first number be the pivot
		final List<Integer> lower = new ArrayList<>(); 
		final List<Integer> higher = new ArrayList<>();
		for (int i = 1; i < numbers.size();i++) {
			if (numbers.get(i) < pivot) {
				lower.add(numbers.get(i));
			} else {
				higher.add(numbers.get(i));
			}
		}
		final List<Integer> sorted = quicksort(lower);
		sorted.add(pivot); 
		sorted.addAll(quicksort(higher));
		return sorted; 
	}

}
