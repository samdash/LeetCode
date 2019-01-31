package linkedlists;

public class FindMiddleElement {
	
	
	public ListNode findMiddle(ListNode head) {
		
		
		ListNode p=head,q=head;
		
		while(q!=null && q.next!=null) {
			p = p.next;
			q = q.next.next;
		}
		
		return p;
		
	}

}
