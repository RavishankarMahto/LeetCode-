class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    @staticmethod
    def deserialize(data):
        """Deserialize a list from a string like '[4,1,8,4,5]'."""
        if not data or data == "[]":
            return None
        
        # Remove brackets and split by commas
        data = data.strip("[]").replace(" ", "")
        nodes = list(map(int, data.split(",")))
        
        # Create the head node
        head = ListNode(nodes[0])
        current = head
        
        # Build the linked list
        for val in nodes[1:]:
            current.next = ListNode(val)
            current = current.next
        
        return head

    @staticmethod
    def serialize(head):
        """Serialize a ListNode to a string like '[4,1,8,4,5]'."""
        if not head:
            return "[]"
        
        result = []
        current = head
        while current:
            result.append(current.val)
            current = current.next
        
        return str(result).replace(" ", "")


class Solution:
    def getIntersectionNode(self, headA, headB):
        """
        Find the intersection node of two singly linked lists.
        :type headA, headB: ListNode
        :rtype: ListNode
        """
        if not headA or not headB:
            return None
        
        # Two pointers
        pointerA, pointerB = headA, headB
        
        # Traverse both lists. When one pointer reaches the end, switch to the other list's head.
        while pointerA != pointerB:
            pointerA = pointerA.next if pointerA else headB
            pointerB = pointerB.next if pointerB else headA
        
        return pointerA


# Example usage
if __name__ == "__main__":
    # Example linked lists
    listA = ListNode.deserialize("[4,1,8,4,5]")
    listB = ListNode.deserialize("[5,6,1,8,4,5]")

    # Assuming the two lists intersect at a node (e.g., node with value 8)
    solution = Solution()
    intersection = solution.getIntersectionNode(listA, listB)

    # Output the intersection node
    if intersection:
        print(f"Intersected at '{intersection.val}'")
    else:
        print("No intersection")
