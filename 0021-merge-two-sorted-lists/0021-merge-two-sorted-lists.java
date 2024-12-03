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

    // Method to deserialize a string representation into a ListNode
    public static ListNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] values = data.substring(1, data.length() - 1).split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String val : values) {
            current.next = new ListNode(Integer.parseInt(val.trim()));
            current = current.next;
        }
        return dummy.next;
    }

    // Method to serialize a ListNode into a string representation
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = this;
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage:
        String list1Str = "[1,2,4]";
        String list2Str = "[1,3,4]";

        ListNode list1 = ListNode.deserialize(list1Str);
        ListNode list2 = ListNode.deserialize(list2Str);

        Solution solution = new Solution();
        ListNode merged = solution.mergeTwoLists(list1, list2);

        // Serialize and print the merged list
        System.out.println(merged != null ? merged.serialize() : "[]");
    }
}
