package _104_maximum_depth_of_binary_tree;

import java.util.ArrayDeque;
import java.util.Queue;

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
    private int maxDepth(TreeNode node, int depth) {
        if (node == null) return depth;
        return Integer.max(maxDepth(node.left, depth + 1), maxDepth(node.right, depth + 1));
    }

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }
}

/**
 * Recursion: From the current node get the max depth of left and right node
 * Time: O(N)
 * Space: O(H)
 */
class SolutionRecursive {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right));
    }
}

class SolutionIterative {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;

            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return depth;
    }
}