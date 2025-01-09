class ListNode {
    int val;
    ListNode next;

    // Constructor to initialize the node
    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("[]")) {
            return null;
        }

        // Remove brackets and spaces, then split by commas
        data = data.replaceAll("\\[|\\]|\\s", "");
        String[] nodes = data.split(",");

        // Create the head node
        ListNode head = new ListNode(Integer.parseInt(nodes[0]));
        ListNode current = head;

        // Build the linked list
        for (int i = 1; i < nodes.length; i++) {
            current.next = new ListNode(Integer.parseInt(nodes[i]));
            current = current.next;
        }

        return head;
    }

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

class Solution {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse both lists. When one reaches the end, switch to the other list's head.
        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // Either they meet at the intersection node or both reach null.
        return pointerA;
    }
}
