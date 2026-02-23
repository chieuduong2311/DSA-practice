package algorithm.week2;

public class MiddleLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode middleNode(ListNode head) {
        ListNode mid = head;
        ListNode iterator = head;
        int count = 0;
        while (iterator != null) {
            count++;
            if (count % 2 == 0) {
                mid = mid.next;
            }
            iterator = iterator.next;
        }
        return mid;
    }
}
