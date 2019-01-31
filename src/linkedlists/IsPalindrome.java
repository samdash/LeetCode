package linkedlists;
import static helpers.Printer.*;

import java.util.Stack;

/*
 * Implement a function to check if a linked list is 
 * a palindrome (like 0->1->2->1->0).
 */
public class IsPalindrome {

    public static void main(String[] args) {
        println(isPalindrome(null));
        println(isPalindrome(ListNode.buildList(new int[] {1})));
        println(isPalindrome(ListNode.buildList(new int[] {1,1})));
        println(isPalindrome(ListNode.buildList(new int[] {1,2,3,4,4,3,2,1})));
    }

	
	
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode p1 = head, p2 = head;
        Stack<Integer> s = new Stack<Integer>();
        while (p2 != null && p2.next != null) {
            s.push(p1.val);
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // handle odd nodes
        if (p2 != null) p1 = p1.next;
        while (p1 != null) {
            if(p1.val != s.pop()) return false;
            p1 = p1.next;
        }
        return true;
    }


}
