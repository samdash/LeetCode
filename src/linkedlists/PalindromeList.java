package linkedlists;

import java.util.Stack;

public class PalindromeList {

	
		ListNode ref;
	    public boolean isPalindrome(ListNode head) {
	        ref = head;        
	        return check(head);
	    }
	    
	    public boolean check(ListNode node){
	        if(node == null) return true;
	        boolean ans = check(node.next);
	        boolean isEqual = (ref.val == node.val)? true : false; 
	        ref = ref.next;
	        return ans && isEqual;
	    }
	    
	    
	    
	    public boolean isPalindromeUsingStack(ListNode head) {
	        Stack<Integer> stack = new Stack<Integer>();
	        ListNode current = head;
	        while (current != null) {
	            stack.push(current.val);
	            current = current.next;
	        }
	        current = head;
	        while (current != null) {
	            if (current.val != stack.pop()) {
	                return false;
	            }
	            current = current.next;
	        }
	        return true;
	    }
	    
	    

}
