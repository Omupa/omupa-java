package model;

public class ListNode {

    public ListNode(ListNode prev, Integer curr, ListNode next) {
        this.prev = prev;
        this.curr = curr;
        this.next = next;
    }

    public ListNode prev;
    public Integer curr;
    public ListNode next;

    public void next(Integer next) {
        var nextNode = new ListNode(this, next, null);
        this.next = nextNode;
    }

    public void prev(Integer prev) {
        this.prev = new ListNode(null, prev, this);
    }

    public String allNodes() {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(this.curr);
            this.next = this.next.next;
        } while (this.next != null);

        return sb.toString();
    }
}
