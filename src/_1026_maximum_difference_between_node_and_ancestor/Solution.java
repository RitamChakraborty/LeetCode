package _1026_maximum_difference_between_node_and_ancestor;

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
    private int diff(TreeNode node, int maxSoFar, int minSoFar) {
        if (node != null) {
            int val = node.val;
            int max = Integer.max(maxSoFar, val);
            int min = Integer.min(minSoFar, val);

            return Integer.max(
                    Integer.max(Math.abs(val - maxSoFar), Math.abs(val - minSoFar)),
                    Integer.max(diff(node.left, max, min), diff(node.right, max, min))
            );
        }

        return 0;
    }

    public int maxAncestorDiff(TreeNode root) {
        return diff(root, root.val, root.val);
    }
}