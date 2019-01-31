package linkedlists;


public class SwapNodesInPairs {

	public static void main(String[] args) {

		MyLinkedList ll = new MyLinkedList();
		for(int i=0;i<4 ;i++) {
				ll.insertAtBegin(new ListNode(i));
		}
		ll.printLinkedList(ll.getHead());
		
		SwapNodesInPairs sip = new SwapNodesInPairs();
		ListNode node = sip.swap(ll.getHead());
		System.out.println();
		ll.printLinkedList(node);
	}

	public ListNode swap(ListNode head) {
		
		if(head == null || head.next == null) return head;
		ListNode p = head;
		ListNode q ;
		ListNode temp;
		ListNode newStart = p.next;
		
		while(true) {
			q = p.next;
			temp = q.next;
			q.next = p;
			if(temp ==null || temp.next == null ) {
				p.next = null;
				break;
			}
			p.next = temp.next;
			p = temp;
		}		
		return newStart;
	}
	
	public ListNode swapPairs(ListNode head) {
	    if(head == null || head.next == null)   
	        return head;
	 
	    ListNode h = new ListNode(0);
	    h.next = head;
	    ListNode p = h;
	 
	    while(p.next != null && p.next.next != null){
	        //use t1 to track first node
	        ListNode t1 = p;
	        p = p.next;
	        t1.next = p.next;
	 
	        //use t2 to track next node of the pair
	        ListNode t2 = p.next.next;
	        p.next.next = p;
	        p.next = t2;
	    }
	 
	    return h.next;
	}
	
		
}
