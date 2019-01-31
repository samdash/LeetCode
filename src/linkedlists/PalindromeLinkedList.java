package linkedlists;

public class PalindromeLinkedList {
	
	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		 
		ll.insertAtEnd(new ListNode(1));
		ll.insertAtEnd(new ListNode(2));
		ll.insertAtEnd(new ListNode(3));
		ll.insertAtEnd(new ListNode(4));
		ll.insertAtEnd(new ListNode(3));
		ll.insertAtEnd(new ListNode(2));
		ll.insertAtEnd(new ListNode(1));
		 
		ll.printLinkedList(ll.getHead());
		
		PalindromeLinkedList pll = new PalindromeLinkedList();
		boolean value = pll.isPalindrome(ll.getHead());
		System.out.println(value);
//		pll.isPalindromeII(ll.getHead());
	}

	
/*
This can be solved by reversing the 2nd half and compare the two halves. Let's start with an example [1, 1, 2, 1].

In the beginning, set two pointers fast and slow starting at the head.

1 -> 1 -> 2 -> 1 -> null 
sf
(1) Move: fast pointer goes to the end, and slow goes to the middle.

1 -> 1 -> 2 -> 1 -> null 
          s          f
(2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.

1 -> 1    null <- 2 <- 1           
h                      s
(3) Compare: run the two pointers head and slow together and compare.

1 -> 1    null <- 2 <- 1             
     h            s	 
*/
	
	public boolean isPalindrome(ListNode head) {
	    ListNode fast = head, slow = head;
	    while (fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    if (fast != null) { // odd nodes: let right half smaller
	        slow = slow.next;
	    }
	    slow = reverse(slow);
	    fast = head;
	    
	    while (slow != null) {
	        if (fast.val != slow.val) {
	            return false;
	        }
	        fast = fast.next;
	        slow = slow.next;
	    }
	    return true;
	}
	
	
	
	public void isPalindromeII(ListNode start) {
		ListNode p , q ,first_start,second_start;
		p = start;
		q = start;
		
		if(p.next == null)          // if there is only one character in the string
		{
			System.out.println("It is a palindrome");
			return;
		}
		//split the linked list
		while(true)
		{
			p = p.next.next;
			if(p == null) // for even number of characters eg : abcddcba
			{
				second_start = q.next;
				break;
			}
			if(p.next == null) // for odd number of characters // abcdcba
			{
				second_start = q.next.next;
				break;
			}		
			q = q.next;		
		}	
		q.next = null; // for odd length ignore the middle element.
		
		//reverse the second linked list
		second_start = reverse(second_start);	
		//now compare the splitted two linked lists
		first_start = start; // shouldn't this be q ?
		while(first_start!=null && second_start!=null) //compare the two strings
		{		
			if(first_start.val == second_start.val)
			{
				first_start = first_start.next;
				second_start = second_start.next;
			}
			else
			{
				System.out.println("\n Not a Palindrome");
				return;					
			}		
		}	
			
		System.out.println("It is a palindrome");
	}
	
	public ListNode reverse(ListNode head) {
		
		ListNode p,q;
		if(head == null ) return null;

		p = head;
		q = p.next;
		
		if(q == null) return p;
		
		q = reverse(q);
		p.next.next = p;
		p.next = null;
		
		
		return q;
	}
	
	public ListNode reverseList(ListNode head) {
	    /* iterative solution */
	    ListNode prev = null;
	    while (head != null) {
	        ListNode next = head.next; 
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}

}
