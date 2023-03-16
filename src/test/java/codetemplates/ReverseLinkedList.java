package codetemplates;

import model.ListNode;

public class ReverseLinkedList {

    public static ListNode fn(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public static void main(String[] args) {
        var one = new ListNode(null, 1, null);
        one.prev(0);
        one.next(2);

        fn(one);
        System.out.println(one.allNodes());
    }
}
