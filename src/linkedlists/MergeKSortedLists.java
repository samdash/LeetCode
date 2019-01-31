package linkedlists;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.isEmpty()) {
            return null;
        }
        //PriorityQueue is a sorted queue
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), (ListNode a, ListNode b) -> {
            if (a.getVal() > b.getVal()) {
                return 1;
            } else if (a.getVal() == b.getVal()) {
                return 0;
            } else {
                return -1;
            }
        });
        //add first node of each list to the queue
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!pq.isEmpty()) {
            //poll() retrieves and removes the head of the queue - q.
            ListNode temp = pq.poll();
            tail.next = temp;
            //keep adding next element of each list
            if (temp.next != null) {
                pq.add(temp.next);
            }
            tail = tail.next;
        }
        return head.next;
    }
}
