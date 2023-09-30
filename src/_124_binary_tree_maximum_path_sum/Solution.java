package _124_binary_tree_maximum_path_sum;

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
    private int maxPathSum(TreeNode root, int[] maxSum) {
        if (root == null) return 0;
        int leftSum = Integer.max(0, maxPathSum(root.left, maxSum));
        int rightSum = Integer.max(0, maxPathSum(root.right, maxSum));
        maxSum[0] = Integer.max(maxSum[0], leftSum + rightSum + root.val);
        return root.val + Integer.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] maxSum = {Integer.MIN_VALUE};
        maxPathSum(root, maxSum);
        return maxSum[0];
    }
}