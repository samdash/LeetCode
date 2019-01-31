package stacks;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int x) {
        if (minstack.isEmpty() || minstack.peek() >= x)  // if x is less than current minStack top value , then push it.
            minstack.push(x);
        stack.push(x);
    }
    
    public void pop() {
        int val = stack.pop();
        if (val==minstack.peek())
            minstack.pop(); // pop from minStack only if it matches
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */