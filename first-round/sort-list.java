public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = sortList(slow.next);
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (l2 != null && l1 != null) {
            if (l2.val < l1.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
            p.next = null;
        }
        if (l2 != null) {
            p.next = l2;
        }
        if (l1 != null) {
            p.next = l1;
        }
        return res.next;
    }
}
