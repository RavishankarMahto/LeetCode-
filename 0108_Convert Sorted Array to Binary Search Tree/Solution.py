# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sortedArrayToBST(self, nums):
        def helper(left, right):
            if left > right:
                return None  # Base case: no elements to process

            # Find the middle element to maintain balance
            mid = (left + right) // 2
            root = TreeNode(nums[mid])

            # Recursively build the left and right subtrees
            root.left = helper(left, mid - 1)
            root.right = helper(mid + 1, right)

            return root
        
        return helper(0, len(nums) - 1)

    # Optional: Helper function to print the tree for debugging
    def preOrder(self, node):
        if node is None:
            return
        print(node.val, end=" ")
        self.preOrder(node.left)
        self.preOrder(node.right)

# Example usage
if __name__ == "__main__":
    solution = Solution()

    nums1 = [-10, -3, 0, 5, 9]
    root1 = solution.sortedArrayToBST(nums1)
    print("Preorder traversal of the first BST:")
    solution.preOrder(root1)
    print()

    nums2 = [1, 3]
    root2 = solution.sortedArrayToBST(nums2)
    print("Preorder traversal of the second BST:")
    solution.preOrder(root2)
    print()
