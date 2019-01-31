package linkedlists;

public class Intersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        ListNode a = headA, b = headB;
	        while (a != b) {
	            a = (a != null) ? a.next : headB;
	            b = (b != null) ? b.next : headA;
	        }
	        return a;
	    }

}
