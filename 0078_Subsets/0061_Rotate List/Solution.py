class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    @staticmethod
    def deserialize(data):
        """Convert a string list representation to a linked list."""
        if not data or data == "[]":
            return None
        values = list(map(int, data.strip("[]").split(",")))
        dummy = ListNode(0)
        current = dummy
        for val in values:
            current.next = ListNode(val)
            current = current.next
        return dummy.next

    @staticmethod
    def serialize(head):
        """Convert a linked list to a string list representation."""
        if not head:
            return "[]"
        result = []
        current = head
        while current:
            result.append(str(current.val))
            current = current.next
        return "[" + ",".join(result) + "]"


class Solution:
    def rotateRight(self, head, k):
        if not head or not head.next or k == 0:
            return head

        # Calculate the length of the linked list
        length = 1
        current = head
        while current.next:
            current = current.next
            length += 1

        # Connect the tail to the head to form a circular list
        current.next = head

        # Find the new head after rotation
        k = k % length  # Normalize k to avoid unnecessary rotations
        steps_to_new_head = length - k
        new_tail = head
        for _ in range(steps_to_new_head - 1):
            new_tail = new_tail.next

        new_head = new_tail.next
        new_tail.next = None  # Break the circular list

        return new_head


# Example Usage
if __name__ == "__main__":
    input_list = "[1,2,3,4,5]"
    k = 2

    head = ListNode.deserialize(input_list)
    solution = Solution()
    rotated_head = solution.rotateRight(head, k)
    output = ListNode.serialize(rotated_head)

    print(output)  # Output: [4,5,1,2,3]
