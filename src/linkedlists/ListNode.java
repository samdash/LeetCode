package linkedlists;


public class ListNode {
    int val;
    ListNode next;
    private static int MAX_PRINT_LENGTH = 500;
    ListNode(int x) {
    	val = x; 
    }
    
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
    
	
	public static ListNode buildList(int[] a) {
        if (a == null || a.length == 0) return null;
        ListNode n = new ListNode(a[0]);
        ListNode head = n;
        for (int i = 1; i < a.length; ++i) {
            n.next = new ListNode(a[i]);
            n = n.next;
        }
        return head;
    }
	
	public static void printList(ListNode n) {
        int i = 0;
        while (n != null) {
            System.out.print(n.val + "->");
            n = n.next;
            if (++i > MAX_PRINT_LENGTH) {
                System.out.println("[MAX_LEN]");
                return;
            }
        }
        System.out.println("NULL");
    }

}
