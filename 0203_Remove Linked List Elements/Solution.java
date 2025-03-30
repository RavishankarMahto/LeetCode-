// package 0203_Remove Linked List Elements;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Deserialize method to create a ListNode from a string
    public static ListNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        data = data.substring(1, data.length() - 1); // Remove brackets
        String[] nodes = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String node : nodes) {
            current.next = new ListNode(Integer.parseInt(node.trim()));
            current = current.next;
        }
        return dummy.next;
    }

    // Serialize method to convert a ListNode to a string
    public static String serialize(ListNode head) {
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
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Traverse the list
        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.val == val) {
                // Skip the node with the target value
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }
        return dummy.next; // Return the new head
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: head = [1,2,6,3,4,5,6], val = 6
        ListNode head = ListNode.deserialize("[1,2,6,3,4,5,6]");
        System.out.println("Original List: " + ListNode.serialize(head));
        head = solution.removeElements(head, 6);
        System.out.println("Modified List: " + ListNode.serialize(head));

        // Example 2: head = [], val = 1
        head = ListNode.deserialize("[]");
        System.out.println("Original List: " + ListNode.serialize(head));
        head = solution.removeElements(head, 1);
        System.out.println("Modified List: " + ListNode.serialize(head));

        // Example 3: head = [7,7,7,7], val = 7
        head = ListNode.deserialize("[7,7,7,7]");
        System.out.println("Original List: " + ListNode.serialize(head));
        head = solution.removeElements(head, 7);
        System.out.println("Modified List: " + ListNode.serialize(head));
    }
}

