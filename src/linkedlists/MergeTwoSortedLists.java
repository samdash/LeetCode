package linkedlists;

/*
 
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
		
	
	
	 public ListNode mergeEasy( ListNode l1, ListNode l2) {
		 
		 ListNode dummy = new ListNode(0);
		 ListNode l3 = dummy;
		 
		 while(l1 != null && l2!=null) {
			 if(l1.val <= l2.val) {
				 l3.next = l1;
				 l1 = l1.next;
			 }else{
				l3.next = l2;
				l2 = l2.next;
			 }
			 l3 = l3.next;
		 }
		 // process remaining elements;
		 
		 if(l1 != null) {
			 l3.next = l1;
		 }
		 
		 if(l2!=null) {
			 l3.next = l2;
		 }
		 
		 return dummy.next;
		 
	 }
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1 == null) return l2;
			if(l2 == null) return l1;
			if(l1.val < l2.val){
				l1.next = mergeTwoLists(l1.next, l2);
				return l1;
			} else{
				l2.next = mergeTwoLists(l1, l2.next);
				return l2;
			}
	    }
	 
	 public ListNode merge(ListNode p, ListNode q) {
		 
		 ListNode newHead = null;
		 ListNode sorting = null;
		 
		 if(p == null) return q;
		 if(q == null) return p;
		 // find the sorting point ( which is lowest in starting values in either of the lists )
		 if( p!= null && q!= null) {
			 if(p.val < q.val) {
				 sorting = p;
				 p = sorting.next;
			 }else {
				 sorting = q;
				 q = sorting.next;
			 }
		 }
		 newHead = sorting;
		 
		 while(p!=null && q!=null) {
			 if(p.val < q.val) {
				 sorting.next = p;
				 sorting = p;
				 p = sorting.next;
			 }else {
				 sorting.next = q;
				 sorting = q;
				 q = sorting.next;
			 }
		 }
		 if(q == null) return sorting.next = p;
		 if(p == null) return sorting.next = q;
		 
		 return newHead;
	 }
}
