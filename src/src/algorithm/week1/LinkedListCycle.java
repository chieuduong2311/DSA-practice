package algorithm.week1;

public class LinkedListCycle {
//    issue 141
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (slowPointer != null && fastPointer != null) {

            slowPointer = slowPointer.next;
            if (fastPointer.next == null) {
                return false;
            }
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

}
