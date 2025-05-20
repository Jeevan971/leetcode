import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode deserialize(String data) {
        if (data == null || data.length() <= 2) return null;
        data = data.substring(1, data.length() - 1);
        String[] parts = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part.trim()));
            current = current.next;
        }
        return dummy.next;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) sb.append(",");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while(true) {
            ListNode kthNode = getKthNode(prevGroupEnd, k);
            if(kthNode == null) break;

            ListNode nextGroupStart = kthNode.next;

            ListNode prev = nextGroupStart;
            ListNode curr = prevGroupEnd.next;

            while(curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = prevGroupEnd.next;
            prevGroupEnd.next = kthNode;
            prevGroupEnd = temp;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while(start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.deserialize("[1,2,3,4,5]");
        int k = 2;
        Solution sol = new Solution();
        ListNode result = sol.reverseKGroup(head, k);
        System.out.println(result); // Output: [2,1,4,3,5]
    }
}
