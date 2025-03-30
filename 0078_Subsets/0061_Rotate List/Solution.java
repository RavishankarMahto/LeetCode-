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

    // Deserialize: Convert a string to a linked list
    public static ListNode deserialize(String data) {
        if (data == null || data.equals("[]")) {
            return null;
        }

        data = data.substring(1, data.length() - 1); // Remove brackets
        String[] values = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String val : values) {
            current.next = new ListNode(Integer.parseInt(val.trim()));
            current = current.next;
        }

        return dummy.next;
    }

    // Serialize: Convert a linked list to a string
    public static String serialize(ListNode head) {
        if (head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(",");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Calculate the length of the list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Connect the tail to the head to form a circular list
        current.next = head;

        // Find the new head
        k = k % length; // Normalize k to avoid unnecessary rotations
        int stepsToNewHead = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Break the circular list
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        // Example Input
        String input = "[1,2,3,4,5]";
        int k = 2;

        // Deserialize input
        ListNode head = ListNode.deserialize(input);

        // Perform rotation
        Solution solution = new Solution();
        ListNode rotatedHead = solution.rotateRight(head, k);

        // Serialize and print output
        String output = ListNode.serialize(rotatedHead);
        System.out.println(output); // Output: [4,5,1,2,3]
    }
}
