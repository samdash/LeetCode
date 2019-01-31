package linkedlists;

public class RotateLinkedList {

	/* 
	 
	 head = a-b-c-d-e-f-g-h-null
	 R = d node  --> rotate at d node
	 
	 Rotated List = e-f-g-h-a-b-c-d-null
	*/
	public ListNode rotate(ListNode head, ListNode R) {
		
		ListNode p,q,newHead;
		p  = head;
		
		while(p!=null) {
			if(R == p) // reach to the node from where we want to rotate
				break;
			p = p.next;
		}
		newHead = p.next;// newHead will now point to e 
		p.next = null; // need to break the link p == d now and d should point to null 
		q = newHead; // let's initialize q and this will move forward until null
		while(q.next != null) {
			q = q.next;
		}
		
		q.next = head; // now q is pointing to a
		
		return newHead;
	}
}
