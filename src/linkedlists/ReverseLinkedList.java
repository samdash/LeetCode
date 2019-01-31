package linkedlists;

import java.util.Stack;

/*
 
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		for(int i=1;i<4 ;i++) {
				ll.insertAtBegin(new ListNode(i));
		}
		ll.printLinkedList(ll.getHead());
		System.out.println();
		ReverseLinkedList rl = new ReverseLinkedList();
//		ListNode node = rl.reverseList(ll.getHead());
//		ll.printLinkedList(node);
		ListNode node = rl.reverse(ll.getHead());
		ll.printLinkedList(node);
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

	public ListNode reverseListRecursive(ListNode head) {
	    /* recursive solution */
	    return reverseListInt(head, null);
	}

	private ListNode reverseListInt(ListNode head, ListNode newHead) {
	    if (head == null)
	        return newHead;
	    ListNode next = head.next;
	    head.next = newHead;
	    return reverseListInt(next, head);
	}
	
	
	
	
	public ListNode reverseListUsingStackValues(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        Stack<Integer> values = new Stack<>();
        ListNode current = head;
        while(current != null) {
            values.push(current.val);
            current = current.next;
        }
        
        ListNode newHead = new ListNode(values.pop());
        ListNode current2 = newHead;
        while(!values.isEmpty()) {
            current2.next = new ListNode(values.pop());
            current2 = current2.next;
        }
        
        return newHead;
    }
	

	public ListNode reverseListStackUsingNodes(ListNode head) {
        
        if (head == null) return null;
        
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode node = head;
        while(node != null) {
            stack.push(node);
            node = node.next;
        }
        
        head = stack.pop();
        node = head;
        while(!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        
        node.next = null;
        return head;
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
	
}
