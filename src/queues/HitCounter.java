package queues;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    /** Initialize your data structure here. */
    Queue<Integer> queue;
    public HitCounter() {
        queue = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            queue.remove();
        }

        return queue.size();
    }
}
