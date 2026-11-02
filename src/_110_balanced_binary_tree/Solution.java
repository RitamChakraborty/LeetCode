package _110_balanced_binary_tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

/**
 * Iterative DFS
 * Memoize the height on every node on traversal.
 */
class SolutionBruteForceDP {
    private int height(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int height = 1 + Integer.max(height(root.left, map), height(root.right, map));
        map.put(root, height);
        return height;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int leftHeight = 0;
            int rightHeight = 0;

            if (node.left != null) {
                leftHeight = height(node.left, map);
                stack.push(node.left);
            }

            if (node.right != null) {
                rightHeight = height(node.right, map);
                stack.push(node.right);
            }

            if (Math.abs(leftHeight - rightHeight) >= 2) return false;
        }

        return true;
    }
}

/**
 * Pass the height and compare
 */
class SolutionTopDown {
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

/**
 * To down recursive DFS
 * Return -1 if the condition isn't valid
 * Time: O(N)
 * Space: O(H)
 */
class SolutionBottomUp {
    private int checkHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = checkHeight(root.left);
        int rightHeight = checkHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Integer.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
}