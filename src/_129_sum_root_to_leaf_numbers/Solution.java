package _129_sum_root_to_leaf_numbers;

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
    private int sumNumbers(TreeNode node, int num) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return num * 10 + node.val;
        }

        return sumNumbers(node.left, num * 10 + node.val) + sumNumbers(node.right, num * 10 + node.val);
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
}