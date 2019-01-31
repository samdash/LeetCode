package linkedlists;


/*
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */


public class MergeKSortedListsII {

	
	
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return  null;
        if(lists.length == 1)
            return lists[0];
        
        return mergeLists(lists, 0, lists.length-1);
    }
    
    public ListNode mergeLists(ListNode[] lists, int start, int end) {
        if(start == end){
            return lists[start];
        }
        else if(start < end){
            int mid = start + (end - start)/2;
            ListNode l1 = mergeLists(lists, start, mid);
            ListNode l2 = mergeLists(lists, mid+1, end);
            return mergeTwoLists(l1, l2);
        }
        else{
            return null;
        }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
            
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
	        l2.next = mergeTwoLists(l1, l2.next);
	        return l2;
        }
               
    }
    
    
}
