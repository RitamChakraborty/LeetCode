package _337_house_robber_iii;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int sum = root.val;

        if (root.left != null) {
            sum += rob(root.left.left);
            sum += rob(root.left.right);
        }

        if (root.right != null) {
            sum += rob(root.right.left);
            sum += rob(root.right.right);
        }

        map.put(root, Integer.max(sum, (rob(root.left) + rob(root.right))));
        return map.get(root);
    }

    private static class TreeNode {
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
}