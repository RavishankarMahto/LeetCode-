/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// Definition for singly-linked list.
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {}
//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {
    public ListNode swapPairs(ListNode head) {
        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        // Traverse the list in pairs
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swap the nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev two nodes ahead
            prev = first;
        }

        return dummy.next;
    }

    // Helper method to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Helper method to create a linked list from an array
    public ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }
}

// Test the solution
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        ListNode head1 = solution.createList(new int[]{1, 2, 3, 4});
        System.out.print("Before swapping: ");
        solution.printList(head1);
        head1 = solution.swapPairs(head1);
        System.out.print("After swapping: ");
        solution.printList(head1);

        // Test Case 2
        ListNode head2 = solution.createList(new int[]{});
        System.out.print("Before swapping: ");
        solution.printList(head2);
        head2 = solution.swapPairs(head2);
        System.out.print("After swapping: ");
        solution.printList(head2);

        // Test Case 3
        ListNode head3 = solution.createList(new int[]{1});
        System.out.print("Before swapping: ");
        solution.printList(head3);
        head3 = solution.swapPairs(head3);
        System.out.print("After swapping: ");
        solution.printList(head3);

        // Test Case 4
        ListNode head4 = solution.createList(new int[]{1, 2, 3});
        System.out.print("Before swapping: ");
        solution.printList(head4);
        head4 = solution.swapPairs(head4);
        System.out.print("After swapping: ");
        solution.printList(head4);
    }
}
