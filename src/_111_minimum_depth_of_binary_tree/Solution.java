package _111_minimum_depth_of_binary_tree;

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
    private int minDepth(TreeNode node, int depth) {
        if (node == null) return Integer.MAX_VALUE;
        if (node.left == null && node.right == null) return depth + 1;
        return Integer.min(minDepth(node.left, depth + 1), minDepth(node.right, depth + 1));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepth(root, 0);
    }
}