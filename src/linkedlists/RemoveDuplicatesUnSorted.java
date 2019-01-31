package linkedlists;

public class RemoveDuplicatesUnSorted {

	public static void main(String[] args) {
		int[] list = {1,1,2,3,3,4,2,5,5};
		ListNode n = ListNode.buildList(list);
		removeDups(n);
		ListNode.printList(n);
	}
	
	public static void removeDups(ListNode n) {
		
		while(n != null) {
			
			ListNode runner = n;
			while(runner.next != null) {
				
				if(runner.next.val == n.val) {
					runner.next = runner.next.next;
				}else {
					runner = runner.next;
				}
			}
			n = n.next;
		}
		
	}

}
