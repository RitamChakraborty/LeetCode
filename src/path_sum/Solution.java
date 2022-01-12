package path_sum;

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
    private boolean hasPathSum(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return false;
        } else if (node.left == null && node.right == null) {
            return sum + node.val == targetSum;
        }

        sum += node.val;
        return hasPathSum(node.left, sum, targetSum) || hasPathSum(node.right, sum, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }
}