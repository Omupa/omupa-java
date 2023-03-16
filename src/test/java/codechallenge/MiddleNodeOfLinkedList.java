package codechallenge;

import java.util.ArrayList;
import java.util.List;

public class MiddleNodeOfLinkedList {

    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static ListNode middleNode(ListNode head) {
        ListNode last = head;
        ListNode middle = head;

        while (last != null && last.next != null) {
            middle = middle.next;
            last = last.next.next;
        }

        return middle;
    }

    /**
     * time complexity O(n)
     * space complexity O(n)
     */
    public static ListNode middleNodeNotBest(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode actualNode = head;
        nodes.add(actualNode);

        while (actualNode.next != null) {
            actualNode = actualNode.next;
            nodes.add(actualNode);
        }

        int middleNodeAt = (nodes.size() / 2);

        return nodes.get(middleNodeAt);
    }

    public static void main(String[] args) {
        ListNode head = ListNode.evenSize();
        ListNode middleNode = middleNode(head);
        System.out.println("Middle node value: " + middleNode.val);
    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode oddSize() {
        return new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))));
    }

    public static ListNode evenSize() {
        return new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5, new ListNode(6))))));
    }

}
