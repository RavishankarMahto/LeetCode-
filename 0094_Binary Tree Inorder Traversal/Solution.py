class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def inorderTraversal(self, root):
        def traverse(node):
            if not node:
                return []
            return traverse(node.left) + [node.val] + traverse(node.right)
        
        return traverse(root)

# Example usage
if __name__ == "__main__":
    # Example 1
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.left = TreeNode(3)
    print(Solution().inorderTraversal(root))  # Output: [1, 3, 2]

    # Example 2
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.right = TreeNode(8)
    root.left.right.left = TreeNode(6)
    root.left.right.right = TreeNode(7)
    root.right.right.left = TreeNode(9)
    print(Solution().inorderTraversal(root))  # Output: [4, 2, 6, 5, 7, 1, 3, 9, 8]

    # Example 3
    root = None
    print(Solution().inorderTraversal(root))  # Output: []

    # Example 4
    root = TreeNode(1)
    print(Solution().inorderTraversal(root))  # Output: [1]
