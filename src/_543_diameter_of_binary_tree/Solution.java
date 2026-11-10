package _543_diameter_of_binary_tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int maxHeight(TreeNode node, int[] d) {
        if (node == null) return 0;
        int leftHeight = maxHeight(node.left, d);
        int rightHeight = maxHeight(node.right, d);
        d[0] = Integer.max(d[0], leftHeight + rightHeight);
        return 1 + Integer.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] d = {0};
        maxHeight(root, d);
        return d[0];
    }
}

class SolutionRecursiveBruteForce {
    public int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Integer.max(maxHeight(root.left), maxHeight(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        return Integer.max(
                leftHeight + rightHeight,
                Integer.max(
                        diameterOfBinaryTree(root.left),
                        diameterOfBinaryTree(root.right)
                )
        );
    }
}

/**
 * Recursion: While calculating the height update the max diameter global variable
 * Time: O(N)
 * Space: O(1)
 */
class SolutionOptimized {
    int max = 0;

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        max = Integer.max(max, left + right);

        return 1 + Integer.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return max;
    }
}