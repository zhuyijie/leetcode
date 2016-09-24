/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0), p = head;
        while (l1 != null && l2 != null) {
            int digit = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            p.next = new ListNode(digit);
            p = p.next;
            l1 = l1.next; l2 = l2.next;
        }
        while (l1 != null) {
            int digit = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            p.next = new ListNode(digit);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int digit = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            p.next = new ListNode(digit);
            p = p.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return head.next;
    }
}
