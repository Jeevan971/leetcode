class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next; // save next node
            current.next = prev;              // reverse current node
            prev = current;                   // move prev forward
            current = nextTemp;               // move current forward
        }

        return prev;
    }
}
