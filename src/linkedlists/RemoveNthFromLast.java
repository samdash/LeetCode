package linkedlists;


/*

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5->6->7, and n = 3.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.
*/

public class RemoveNthFromLast {

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		 
		ll.insertAtEnd(new ListNode(1));
		ll.insertAtEnd(new ListNode(2));
		ll.insertAtEnd(new ListNode(3));
		ll.insertAtEnd(new ListNode(4));
		ll.insertAtEnd(new ListNode(5));
		ll.insertAtEnd(new ListNode(6));
		ll.insertAtEnd(new ListNode(7));
		ll.insertAtEnd(new ListNode(8));


		
		ll.printLinkedList(ll.getHead());
		System.out.println();
		RemoveNthFromLast r = new RemoveNthFromLast();
		ListNode node = r.removeNthFromEnd(ll.getHead(), 4);
		ll.printLinkedList(node);

		
	}
	
	
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head, follower = head;
        while(n-- > 0) { 
        	curr = curr.next;
        }
        if(curr == null) return head.next;
        while(curr.next != null){
            curr = curr.next;
            follower = follower.next;
        }
        follower.next = follower.next.next;
        return head;

    }
	

}

