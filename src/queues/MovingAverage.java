package queues;

import java.util.LinkedList;
import java.util.Queue;


/*
 Given a stream of integers and a q size, calculate the moving average of all integers in the sliding q.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverage {
	int size;
    Queue<Integer> q;
    double sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        q = new LinkedList<Integer>();
        sum = 0; 
    }
    
    public double next(int val) {
        q.add(val);
        if(q.size() > size) {
            sum -= q.remove();
        }
        sum += val;
        return sum / q.size();
    }
    
    
    public static void main(String[] args) {
    	MovingAverage obj = new MovingAverage(3);
    	double value = obj.next(3);
    	double value1 = obj.next(5);
    	double value2 = obj.next(15);

    	System.out.println(value2);
    	
	}

}
