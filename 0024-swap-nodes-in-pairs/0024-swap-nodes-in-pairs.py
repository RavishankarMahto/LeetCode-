# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def swapPairs(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        # Dummy node to simplify edge cases
        dummy = ListNode(-1)
        dummy.next = head
        prev = dummy

        # Traverse the list in pairs
        while prev.next and prev.next.next:
            first = prev.next
            second = prev.next.next

            # Swapping the nodes
            first.next = second.next
            second.next = first
            prev.next = second

            # Move prev two nodes ahead
            prev = first

        return dummy.next

# Helper functions for testing
def list_to_linked_list(lst):
    dummy = ListNode(0)
    current = dummy
    for val in lst:
        current.next = ListNode(val)
        current = current.next
    return dummy.next

def linked_list_to_list(head):
    result = []
    while head:
        result.append(head.val)
        head = head.next
    return result

# Testing the solution
solution = Solution()

# Test Case 1
head = list_to_linked_list([1, 2, 3, 4])
print(linked_list_to_list(solution.swapPairs(head)))  # Output: [2, 1, 4, 3]

# Test Case 2
head = list_to_linked_list([])
print(linked_list_to_list(solution.swapPairs(head)))  # Output: []

# Test Case 3
head = list_to_linked_list([1])
print(linked_list_to_list(solution.swapPairs(head)))  # Output: [1]

# Test Case 4
head = list_to_linked_list([1, 2, 3])
print(linked_list_to_list(solution.swapPairs(head)))  # Output: [2, 1, 3]
