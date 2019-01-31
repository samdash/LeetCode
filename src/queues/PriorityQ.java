package queues;

/*Priority Queue

In priority queue, the elements are ordered according to the key values. 
The element with the lowest key value may be the head of the queue 
or it may be the last element in the queue depending on the programming language.

poll() removes the element with the largest priority value
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQ{

	public static void main(String[] args){
		PriorityQueue<String> queue =  new PriorityQueue<String>(10, 
			new Comparator<String>(){
			public int compare(String car1, String car2){
				int price1 = Integer.parseInt(car1.split(":")[1].trim());
				int price2 = Integer.parseInt(car2.split(":")[1].trim());
				return price2 - price1;
			}
		});


		queue.add("Maserati GranTurismo: 523000");
		queue.add("MINI Cooper: 150800");
		queue.add("Lexus: 220000");
		queue.add("McLaren: 998000");
		queue.add("Ferrari: 1160000");
		queue.add("Tesla: 70000");


		while(!queue.isEmpty()){
			System.out.println(queue.poll());
		}

	}

}