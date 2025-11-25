package algorithm.week1;

public class MergeTwoSortedLists {
//    issue 21
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = new ListNode();
        ListNode current = result;

        while (current != null) {
            if (list1.val > list2.val) {
                current.val = list2.val;

                if (list2.next == null) {
                    current.next = list1;
                    return result;
                }
                list2 = list2.next;

            } else {
                current.val = list1.val;

                if (list1.next == null) {
                    current.next = list2;
                    return result;
                }
                list1 = list1.next;
            }
            current.next = new ListNode();
            current = current.next;
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
