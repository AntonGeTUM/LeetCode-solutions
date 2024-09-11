public class InsertGCDInLinkedList {

    /**
     * Given a LinkedList, insert a new node between every two nodes and set the greatest common divisor
     * of both nodes as the value of the new node.
     * Example: 18 -> 6 -> 10 -> 3
     *          18 -> 6 -> 6 -> 2 -> 10 -> 1 -> 3
     * Explanation: the GCD of 18 and 6 is 6 -> insert new node with value 6
     *              the GCD of 6 and 10 is 2 -> insert new node with value 2
     *              ...
     * Solution: For every node, consider its own value and the value of the next node (if exists). Determine the GCD
     *           of both values and insert a new node into the LinkedList. Skip the new node while walking over
     *           the list.
     * **/

    public static class ListNode {
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
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            cur.next = new ListNode(gcd(cur.val, cur.next.val), cur.next);
            cur = cur.next.next;
        }
        return head;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
