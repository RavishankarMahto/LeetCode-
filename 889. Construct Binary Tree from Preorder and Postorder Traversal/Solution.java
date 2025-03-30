import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> postIndexMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // Store postorder indices in a HashMap for quick lookup
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return buildTree(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] postorder, int left, int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (left == right) return root; // Base case for leaf nodes

        // Find left subtree root in postorder
        int leftRootIndex = postIndexMap.get(preorder[preIndex]);

        // Recursively construct left and right subtrees
        root.left = buildTree(preorder, postorder, left, leftRootIndex);
        root.right = buildTree(preorder, postorder, leftRootIndex + 1, right - 1);

        return root;
    }

    // Helper method to print tree in level order
    public void printLevelOrder(TreeNode root) {
        if (root == null) return;

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        TreeNode root = solution.constructFromPrePost(preorder, postorder);
        System.out.print("Level Order Traversal: ");
        solution.printLevelOrder(root); // Expected Output: 1 2 3 4 5 6 7
    }
}
