package linkedlists;

import java.util.ArrayList;
import java.util.List;

/**
 * Partition: Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than
 * or equal to x. lf x is contained within the list, the values of x only need
 * to be after the elements less than x (see below).The partition element x can
 * appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input:  3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition=5)
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 * Hints: #3, #24
 */
public class Partition {
    public static void main(String[] args) {
        LNode<Integer> node1 = new LNode<>(1, null);
        LNode<Integer> node2 = new LNode<>(2, node1);
        LNode<Integer> node3 = new LNode<>(4, node2);
        LNode<Integer> node4 = new LNode<>(5, node3);
        LNode<Integer> node5 = new LNode<>(3, node4);

        System.out.println(solution1(node5, node3)); // expected output: [3, 2, 1, 4, 5]
    }

    private static List<LNode<Integer>> solution1(LNode<Integer> root, LNode<Integer> partition) {
        List<LNode<Integer>> l1 = new ArrayList<>();
        List<LNode<Integer>> l2 = new ArrayList<>();

        while (root != null) {
            if (root.getValue() < partition.getValue()) {
                l1.add(root);
            } else if (root.getValue() > partition.getValue()){
                l2.add(root);
            }
            root = root.getNext();
        }

        l1.add(partition);
        l1.addAll(l2);
        return l1;
    }
}

class LNode<T> {
    private T value;
    private LNode<T> next;

    public LNode(T value, LNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(LNode<T> next) {
        this.next = next;
    }

    public LNode<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return value + "";
    }
}