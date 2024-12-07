# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    @staticmethod
    def deserialize(data):
        """Converts a serialized list string (e.g., '[1,2,3]') into a linked list."""
        if not data or data == "[]":
            return None

        # Remove brackets and split the string into integers
        values = list(map(int, data.strip("[]").split(",")))

        # Create the linked list
        dummy = ListNode(0)
        current = dummy
        for val in values:
            current.next = ListNode(val)
            current = current.next

        return dummy.next

    @staticmethod
    def serialize(head):
        """Converts a linked list into a serialized list string."""
        result = []
        while head:
            result.append(head.val)
            head = head.next
        return str(result)


class Solution:
    def removeNthFromEnd(self, head, n):
        dummy = ListNode(0)
        dummy.next = head
        slow = fast = dummy

        # Move fast pointer n+1 steps ahead
        for _ in range(n + 1):
            fast = fast.next

        # Move both pointers until fast reaches the end
        while fast:
            slow = slow.next
            fast = fast.next

        # Remove the nth node
        slow.next = slow.next.next

        return dummy.next


# Example usage
if __name__ == "__main__":
    # Input data
    serialized_list = "[1,2,3,4,5]"
    n = 2

    # Deserialize the input
    head = ListNode.deserialize(serialized_list)

    # Solve the problem
    solution = Solution()
    result = solution.removeNthFromEnd(head, n)

    # Serialize and print the output
    print("Output:", ListNode.serialize(result))

        