class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def flatten(self, root):
        current = root
        while current:
            if current.left:
                # Find the rightmost node of the left subtree
                rightmost = current.left
                while rightmost.right:
                    rightmost = rightmost.right
                # Connect the rightmost node of the left subtree to the current node's right subtree
                rightmost.right = current.right
                # Move the left subtree to the right and set the left pointer to None
                current.right = current.left
                current.left = None
            # Move to the next node (right child)
            current = current.right

# Helper function to create a tree from a list
def create_tree_from_list(values):
    if not values:
        return None
    nodes = [TreeNode(val) if val is not None else None for val in values]
    for i in range(len(nodes)):
        if nodes[i] is not None:
            if 2 * i + 1 < len(nodes):
                nodes[i].left = nodes[2 * i + 1]
            if 2 * i + 2 < len(nodes):
                nodes[i].right = nodes[2 * i + 2]
    return nodes[0]

# Helper function to print the flattened tree as a list
def print_flattened_tree(root):
    current = root
    result = []
    while current:
        result.append(current.val)
        current = current.right
    print(result)

# Example usage
solution = Solution()

# Example 1: Tree [1, 2, 5, 3, 4, None, 6]
root1 = create_tree_from_list([1, 2, 5, 3, 4, None, 6])
solution.flatten(root1)
print_flattened_tree(root1)  # Output: [1, 2, 3, 4, 5, 6]

# Example 2: Tree []
root2 = create_tree_from_list([])
solution.flatten(root2)
print_flattened_tree(root2)  # Output: []

# Example 3: Tree [0]
root3 = create_tree_from_list([0])
solution.flatten(root3)
print_flattened_tree(root3)  # Output: [0]
