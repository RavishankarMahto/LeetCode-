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
import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        traverse(node.left, result);
        result.add(node.val);
        traverse(node.right, result);
    }
}

public class Main {
    public static void main(String[] args) {
        // Example 1: Tree [1, null, 2, 3]
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.inorderTraversal(root1)); // Output: [1, 3, 2]

        // Example 2: Tree [1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(8);
        root2.left.right.left = new TreeNode(6);
        root2.left.right.right = new TreeNode(7);
        root2.right.right.left = new TreeNode(9);

        System.out.println(solution.inorderTraversal(root2)); // Output: [4, 2, 6, 5, 7, 1, 3, 9, 8]

        // Example 3: Empty tree
        TreeNode root3 = null;
        System.out.println(solution.inorderTraversal(root3)); // Output: []

        // Example 4: Tree with a single node [1]
        TreeNode root4 = new TreeNode(1);
        System.out.println(solution.inorderTraversal(root4)); // Output: [1]
    }
}
