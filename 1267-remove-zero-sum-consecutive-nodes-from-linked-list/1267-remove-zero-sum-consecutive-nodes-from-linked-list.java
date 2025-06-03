import java.util.HashMap;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        HashMap<Integer, ListNode> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        ListNode current = dummy;

        // First pass: Map prefix sums to nodes
        while (current != null) {
            prefixSum += current.val;
            prefixSumMap.put(prefixSum, current);
            current = current.next;
        }

        // Second pass: Remove zero-sum sequences
        prefixSum = 0;
        current = dummy;
        while (current != null) {
            prefixSum += current.val;
            // Jump to the last occurrence of this prefixSum, skipping nodes in between
            ListNode node = prefixSumMap.get(prefixSum);
            if (node != current) {
                current.next = node.next;
            }
            current = current.next;
        }

        return dummy.next;
    }
}
