package linkedlists;

public class MyLinkedList {

	private int length = 0;
	// This is the only field of the class.  It holds the head of the list 
	ListNode head;
	
	public MyLinkedList() {
		length = 0;
	}
	
	// Return the first node in the list 
	public  ListNode getHead() { 
		return head; 
	}
	
	// Insert a node at the beginning of the list 
	public  void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length ++;
	}

	// Insert a node at the end of the list 
	public  void insertAtEnd(ListNode node) {
		if(head == null) {
			head = node;
		}else {
			ListNode p = head;
			while(p.getNext() !=null) {
				p = p.getNext();
			}
			 p.setNext(node);
		}		length ++;
	}
	
	// Remove and return the node at the head of the list 
	public  ListNode removeFromBegin() {
		ListNode node = head;
		if (node != null) {
			head = node.getNext();
			node.setNext(null);
		}
		return node;
	}

	public void removedAtEnd() {
		if(head==null) {
			return;
		}else {
			ListNode p = head;
			while(p.getNext().getNext()!=null) {
				p = p.getNext();
			}
			p.setNext(p.getNext().getNext());
		}
		
	}
	
	// Size of the list.
	public boolean isEmpty(){
		return length==0;
	}
	
	// Remove everything from the list.
	public void clearList(){
		head = null;
		length = 0;
	}
	
	public void reverseLinkedList(ListNode node) {
		if(node != null) {
			reverseLinkedList(node.getNext());
			System.out.println(node.getVal());
		}
	}

	public void printLinkedList(ListNode node) {
		
		if(node==null) {
			return;
		}
		while(node != null) {
			System.out.print(node.getVal()+" ");
			node = node.getNext();
			
		}
		
	}

	
}
