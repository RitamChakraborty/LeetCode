package _226_invert_binary_tree;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * Recursive DFS
 * Recursively exchange the left and right
 * Time: O(N)
 * Space: O(H)
 */
class SolutionRecursive {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}

/**
 * Iterative DFS
 * Top-down approach; Start from root reverse the left & right and add them to the stack
 * Time: O(N)
 * Space: O(H)
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (left != null) stack.push(left);
            if (right != null) stack.push(right);
        }

        return root;
    }
}
