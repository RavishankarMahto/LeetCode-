class ListNode {
    int val;
    ListNode next;

    // Constructors
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Method to deserialize a string into a ListNode
    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("[]")) {
            return null;
        }

        // Remove brackets and split the string by commas
        data = data.replaceAll("\\[|\\]", "");
        String[] values = data.split(",");

        // Create the linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String value : values) {
            current.next = new ListNode(Integer.parseInt(value.trim()));
            current = current.next;
        }

        return dummy.next;
    }

    // Method to serialize a ListNode into a string
    public static String serialize(ListNode node) {
        if (node == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(",");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify result creation
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // Traverse both linked lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            // Add values from l1 and l2, if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Compute carry and the current digit
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        // Return the result list starting from the next of dummy node
        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example inputs
        ListNode l1 = ListNode.deserialize("[2,4,3]");
        ListNode l2 = ListNode.deserialize("[5,6,4]");

        // Call the solution
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        System.out.println(ListNode.serialize(result)); // Output: [7,0,8]
    }
}
