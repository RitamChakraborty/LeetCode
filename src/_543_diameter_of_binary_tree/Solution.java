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