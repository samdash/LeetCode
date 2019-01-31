package linkedlists;
import static helpers.Printer.*;

/*
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class nthToLast {

    //TEST----------------------------------
    public static void main(String[] args) {
        int[] list = {15,14,33,23,11,10};
        ListNode n = ListNode.buildList(list);
        println(nthToLast(n, 0));
        println(nthToLast(n, 3));
        println(nthToLast(n, 5));
        println(nthToLast(n, 6));
        println(nthToLast(n, -100));
        println(nthToLast(n, 100));
    }
    
    
	//Returns nearest node if index out of bounds.
    public static int nthToLast(ListNode head, int k) {
        ListNode n = head, r = head;
        for (int i = 0; i < k; ++i) {
            r = r.next;
            if (r == null) return n.val;
        }
        while (r.next != null) {
            r = r.next;
            n = n.next;
        }
        return n.val;
    }

    
}
