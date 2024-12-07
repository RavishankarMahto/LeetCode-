class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Method to deserialize a string into a linked list
    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("[]")) {
            return null;
        }

        // Remove brackets and split by comma
        data = data.replace("[", "").replace("]", "");
        String[] values = data.split(",");

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String val : values) {
            current.next = new ListNode(Integer.parseInt(val.trim()));
            current = current.next;
        }

        return dummy.next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example input
        String serializedList = "[1,2,3,4,5]";
        int n = 2;

        // Deserialize the input to create a linked list
        ListNode head = ListNode.deserialize(serializedList);

        Solution solution = new Solution();
        ListNode result = solution.removeNthFromEnd(head, n);

        // Print the resulting list
        printList(result);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
