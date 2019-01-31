package design;

import java.util.Stack;

public class QueueWith2Stacks {

	 // Stack to keep track of elements inserted into the queue
    private Stack<Integer> inStack;
    // Stack to keep track of elements to be removed next in queue
    private Stack<Integer> outStack;

    /**
	 * Constructor
	 */
    public QueueWith2Stacks() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    /**
     * Inserts an element at the rear of the queue
     *
     * @param x element to be added
     */
    public void insert(int x) {
        // Insert element into inStack
        this.inStack.push(x);
    }

    /**
     * Remove an element from the front of the queue
     *
     * @return the new front of the queue
     */
    public int remove() {
        if(this.outStack.isEmpty()) {
            // Move all elements from inStack to outStack (preserving the order)
            while(!this.inStack.isEmpty()) {
                this.outStack.push( this.inStack.pop() );
            }
        }
        return this.outStack.pop();
    }

    /**
     * Peek at the element from the front of the queue
     *
     * @return the front element of the queue
     */
    public int peekFront() {
        if(this.outStack.isEmpty()) {
            // Move all elements from inStack to outStack (preserving the order)
            while(!this.inStack.isEmpty()) {
                this.outStack.push( this.inStack.pop() );
            }
        }
        return this.outStack.peek();
    }

    /**
     * Peek at the element from the back of the queue
     *
     * @return the back element of the queue
     */
    public int peekBack() {
        return this.inStack.peek();
    }

    /**
     * Returns true if the queue is empty
     *
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return (this.inStack.isEmpty() && this.outStack.isEmpty());
    }
    
    
	public static void main(String[] args) {

		QueueWith2Stacks myQueue = new QueueWith2Stacks();
		myQueue.insert(1);
        System.out.println(myQueue.peekBack()); //Will print 1
        // instack: [(top) 1]
        // outStack: []
        myQueue.insert(2);
        System.out.println(myQueue.peekBack()); //Will print 2
        // instack: [(top) 2, 1]
        // outStack: []
        myQueue.insert(3);
        System.out.println(myQueue.peekBack()); //Will print 3
        // instack: [(top) 3, 2, 1]
        // outStack: []
        myQueue.insert(4);
        System.out.println(myQueue.peekBack()); //Will print 4
        // instack: [(top) 4, 3, 2, 1]
        // outStack: []

        System.out.println(myQueue.isEmpty()); //Will print false

        System.out.println(myQueue.remove()); //Will print 1
        // instack: []
        // outStack: [(top) 2, 3, 4]

        myQueue.insert(5);
        System.out.println(myQueue.peekFront()); //Will print 2
        // instack: [(top) 5]
        // outStack: [(top) 2, 3, 4]

        myQueue.remove();
        System.out.println(myQueue.peekFront()); //Will print 3
        // instack: [(top) 5]
        // outStack: [(top) 3, 4]
        myQueue.remove();
        System.out.println(myQueue.peekFront()); //Will print 4
        // instack: [(top) 5]
        // outStack: [(top) 4]
        myQueue.remove();
        // instack: [(top) 5]
        // outStack: []
        System.out.println(myQueue.peekFront()); //Will print 5
        // instack: []
        // outStack: [(top) 5]
        myQueue.remove();
        // instack: []
        // outStack: []

        System.out.println(myQueue.isEmpty()); //Will print true
	}

}
