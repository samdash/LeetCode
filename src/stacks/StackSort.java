package stacks;

import java.util.Stack;

public class StackSort {

	public static void main(String[] args) {
		 Stack<Integer> stack = new Stack<Integer>();
		 stack.push(10);
		 stack.push(1);
		 stack.push(5);
		 stack.push(8);
		 stack.push(3);
		 stack.push(2);
		 
		 sortStack(stack);
		 

	}
	
	/** the basic idea is we go on popping one element from the original
	 * stack (s) and we compare it with the new stack (temp) if the popped
	 * element from original stack is < the peek element from new stack temp
	 * than we push the new stack element to original stack and recursively keep
	 * calling till temp is not empty and than push the element at the right
	 * place. else we push the element to the new stack temp if original element
	 * popped is > than new temp stack. Entire logic is recursive.
	 */
	public static void sortStack(Stack<Integer> s) {
		Stack<Integer> temp = new Stack<Integer>();

	    while( !s.isEmpty() )
	    {
	        int s1 = (int) s.pop();

	        while( !temp.isEmpty() && (temp.peek() > s1) )
	        {
	            s.push( temp.pop() );
	        }
	        temp.push( s1 );
	    }

	    // Print the entire sorted stack from temp stack
	    for( int i = 0; i < temp.size(); i++ )
	    {
	        System.out.println( temp.elementAt( i ) );
	    }
		
		
	}
}
