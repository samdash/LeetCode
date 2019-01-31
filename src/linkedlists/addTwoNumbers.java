package linkedlists;

public class addTwoNumbers {

	
	   public class ListNode {
		      int data;
		      ListNode next;
		      ListNode(int x) { data = x; }
	   }

	   public ListNode add2Numbers(ListNode l1, ListNode l2) {
	        ListNode dummyHead = new ListNode(0);
	        ListNode p = l1, q = l2, curr = dummyHead;
	        int carry = 0;
	        while (p != null || q != null) {
	            int x = (p != null) ? p.data : 0;
	            int y = (q != null) ? q.data : 0;
	            int sum = carry + x + y;
	            carry = sum / 10;
	            curr.next = new ListNode(sum % 10);
	            curr = curr.next;
	            if (p != null) p = p.next;
	            if (q != null) q = q.next;
	        }
	        if (carry > 0) {
	            curr.next = new ListNode(carry);
	        }
	        return dummyHead.next;
	    }
	   
	   
	   public ListNode addNumbers(ListNode l1, ListNode l2) {
		   ListNode dummy = new ListNode(0);
		   
		   ListNode l3 = dummy;
		   int carry = 0;
		   
		   while(l1 != null && l2 != null) {
			   int digitValue = ( l1.data + l2.data + carry) %10;
			   carry = (l1.data + l2.data + carry) / 10;
			   ListNode newNode = new ListNode(digitValue);
			   l3.next = newNode;
			   l3 = newNode;
			   l1 = l1.next;
			   l2 = l2.next;
		   }
		   
		   while(l1!= null) // handle cases when 2 numbers are not of same length like 12 + 9
		   {
			   int digitValue = ( l1.data + carry) %10;
			   carry = (l1.data + carry) / 10;
			   ListNode newNode = new ListNode(digitValue);
			   l3.next = newNode;
			   l3 = newNode;
			   l1 = l1.next;
			   
		   }
		   while(l2!= null) // handle cases when 2 numbers are not of same length like 12 + 9
		   {
			   int digitValue = ( l2.data + carry) %10;
			   carry = (l2.data + carry) / 10;
			   ListNode newNode = new ListNode(digitValue);
			   l3.next = newNode;
			   l3 = newNode;
			   l2 = l2.next;
			   
		   }
		   // 2 + 9  = 11 
		   if(carry != 0) {
			   ListNode newNode = new ListNode(carry);
			   l3.next = newNode;
			   l3 = newNode;
		   }
		   return dummy.next;
	   }
 
}


 