/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            // If the node has a left subtree
            if (current.left != null) {
                // Find the rightmost node of the left subtree
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                // Reconnect the rightmost node of the left subtree to the right subtree
                rightmost.right = current.right;
                // Move the left subtree to the right
                current.right = current.left;
                current.left = null;
            }
            // Move to the next node (right child)
            current = current.right;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Tree [1, 2, 5, 3, 4, null, 6]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(6);

        solution.flatten(root1);
        printFlattenedTree(root1); // Output: [1, null, 2, null, 3, null, 4, null, 5, null, 6]

        // Example 2: Tree []
        TreeNode root2 = null;
        solution.flatten(root2);
        printFlattenedTree(root2); // Output: []

        // Example 3: Tree [0]
        TreeNode root3 = new TreeNode(0);
        solution.flatten(root3);
        printFlattenedTree(root3); // Output: [0]
    }

    private static void printFlattenedTree(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
        System.out.println();
    }
}
