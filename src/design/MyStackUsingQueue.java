package design;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackUsingQueue {
	
	   private Queue<Integer> data;    
	    /** Initialize your data structure here. */    
	    public MyStackUsingQueue() {        
	        data=new LinkedList<>();    
	    }        /** Push element x onto stack. */    
	    public void push(int x) 
	    {        
	        Queue<Integer> temp=new LinkedList<>();		
	        temp.add(x);		
	        while(!data.isEmpty())			
	            temp.add(data.poll());		
	        data=temp;    
	    }        /** Removes the element on top of the stack and returns that element. */    
	    public int pop() 
	    {        
	        return data.poll();    
	    }        
	    /** Get the top element. */    
	    public int top() 
	    {        
	        return data.peek();    
	    }        
	    /** Returns whether the stack is empty. */    
	    public boolean empty() 
	    {        
	        return data.isEmpty();    
	    }

	    public static void main(String[] args) {
	    	MyStackUsingQueue s = new MyStackUsingQueue();
	        s.push(1);
	        s.push(2);
	        s.push(3);
	        for (int i = 0; i < 4; ++i) {
	            if (!s.empty()) {
	                System.out.println(s.pop());
	            }
	        }
	    }
	    
	/**
	 * Your MyStack object will be instantiated and called as such:
	 * MyStack obj = new MyStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
}
