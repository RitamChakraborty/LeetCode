package _110_balanced_binary_tree;

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
    private int isBalanced(TreeNode node, int depth) {
        if (node == null) return depth;
        int leftHeight = isBalanced(node.left, depth + 1);
        int rightHeight = isBalanced(node.right, depth + 1);
        int diff = Math.abs(leftHeight - rightHeight);
        if (diff > 1) return -1;
        return Integer.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root, 0) != -1;
    }
}