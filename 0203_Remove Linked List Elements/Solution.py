class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    @staticmethod
    def deserialize(data):
        """Convert a list into a linked list."""
        if not data:
            return None
        dummy = ListNode(0)
        current = dummy
        for val in data:
            current.next = ListNode(val)
            current = current.next
        return dummy.next

    @staticmethod
    def serialize(head):
        """Convert a linked list into a list."""
        result = []
        current = head
        while current:
            result.append(current.val)
            current = current.next
        return result


class Solution:
    def removeElements(self, head, val):
        """Remove all elements with the given value from the linked list."""
        # Create a dummy node to handle edge cases
        dummy = ListNode(0)
        dummy.next = head

        # Traverse the linked list
        current = dummy
        while current and current.next:
            if current.next.val == val:
                current.next = current.next.next  # Remove the node
            else:
                current = current.next
        return dummy.next


# Test cases
if __name__ == "__main__":
    solution = Solution()

    # Example 1: head = [1,2,6,3,4,5,6], val = 6
    head = ListNode.deserialize([1, 2, 6, 3, 4, 5, 6])
    print("Original List:", ListNode.serialize(head))
    head = solution.removeElements(head, 6)
    print("Modified List:", ListNode.serialize(head))

    # Example 2: head = [], val = 1
    head = ListNode.deserialize([])
    print("Original List:", ListNode.serialize(head))
    head = solution.removeElements(head, 1)
    print("Modified List:", ListNode.serialize(head))

    # Example 3: head = [7,7,7,7], val = 7
    head = ListNode.deserialize([7, 7, 7, 7])
    print("Original List:", ListNode.serialize(head))
    head = solution.removeElements(head, 7)
    print("Modified List:", ListNode.serialize(head))
