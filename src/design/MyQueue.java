package design;

import java.util.Stack;

public class MyQueue<T> {
	
	private Stack<T> stackNewestOnTop = new Stack<T>();
	private Stack<T> stackOldestOnTop = new Stack<T>();
	
	
	public void  enqueue(T value) {
		stackNewestOnTop.push(value);
	}
	
	public T peek() {
		shiftStacks();
		return stackOldestOnTop.peek();
	}
	
	public T dequeue() {
		shiftStacks();
		return stackOldestOnTop.pop();
	}
	
	private void shiftStacks() {
		if(stackOldestOnTop.isEmpty()) {
			while(!stackNewestOnTop.isEmpty()) {
				stackOldestOnTop.push(stackNewestOnTop.pop());
			}
		}
	}
	
	public boolean isEmpty() {
		return (stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty());
	}
	
	
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<>();
		for(int i=0;i< 6;i++) {
			q.enqueue(i);
		}

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
	}

}
