import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static ListNode deserialize(String data) {
        if (data == null || data.equals("[]")) {
            return null;
        }
        String[] values = data.replaceAll("\\[|\\]", "").split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String value : values) {
            current.next = new ListNode(Integer.parseInt(value.trim()));
            current = current.next;
        }
        return dummy.next;
    }
}

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.deserialize("[3,2,0,-4]");
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head)); // Adjust if needed to create a cycle.
    }
}
