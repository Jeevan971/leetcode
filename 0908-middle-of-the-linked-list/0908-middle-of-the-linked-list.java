import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    
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

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) sb.append(" -> ");
            node = node.next;
        }
        return sb.toString();
    }
}

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; 
    }

    public static void main(String[] args) {
        
        String input = "[1,2,3,4,5]";
        ListNode head = ListNode.deserialize(input);
        Solution sol = new Solution();
        ListNode middle = sol.middleNode(head);
        System.out.println("Middle node onwards: " + middle);
    }
}
