public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>(new NodeComparator());
        ListNode head = new ListNode(-1), current = head;
        for (ListNode ln : lists) {
            if (ln != null) {
                pQueue.offer(ln);
            } 
        }
        while (!pQueue.isEmpty()) {
            ListNode ln = pQueue.poll();
            if (ln.next != null) {
                pQueue.offer(ln.next);
            }
            current.next = new ListNode(ln.val);
            current = current.next;
        }
        return head.next;
    }
}

class NodeComparator implements Comparator<ListNode> {
    public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
    }
}
