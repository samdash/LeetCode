package queues;


/**
Similar to design Queue using LinkedList, we will internally maintian an array A with two index, front and rear.

front to store the head element of the queue
tail to store the tail element queue.
we internally maintain the size of the current queue.
When we add a new element to the queue, we will update rear, size and A[rear]. When we delete the head element of the queue, we will update front, size.

Little trick: use mod operation to avoid index out of bound error, and do a little checking of size before each enqueue and dequeue operation.
 */
public class MyCircularQueue {
    private int[] A;
    private int front; 
    private int rear;
    private int size;
    private int capacity;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        A = new int[k];
        front = 0;
        rear = 0;
        size = 0;
        capacity = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size == capacity) return false;
        rear = (front + size) % capacity;
        A[rear] = value;
        size++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size == 0) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (size == 0) return -1;
        return A[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (size == 0) return -1;
        return A[rear];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
    
    public static void main(String[] args) {
    	MyCircularQueue mcq = new MyCircularQueue(5);
    	mcq.enQueue(2);
    	mcq.enQueue(3);
    	mcq.enQueue(4);
    	mcq.deQueue();
    	mcq.deQueue();
    	mcq.deQueue();
    	    	
	}
    
}
