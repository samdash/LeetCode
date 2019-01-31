package linkedlists;

import static helpers.Printer.*;

/*
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 */
public class RemoveMiddleNode {


    public static void main(String[] args) {
        int[] list = {3,2,1,0};
        ListNode head = ListNode.buildList(list);
        ListNode n1 = head.next,
                       n2 = head.next.next.next,
                       n3 = null;
        println("DELETE " + n3 + ": " + deleteNode(n3));
        ListNode.printList(n3);
        println("DELETE " + n2 + ": " + deleteNode(n2));
        ListNode.printList(n2);
        println("DELETE " + n1 + ": " + deleteNode(n1));
        ListNode.printList(n1);
    }
    
    
	 static boolean deleteNode(ListNode n) {
	        //fail if the node is the last element.
	        if (n == null || n.next == null) return false;
	        n.val = n.next.val;
	        n.next = n.next.next;
	        return true;
	    }


}
