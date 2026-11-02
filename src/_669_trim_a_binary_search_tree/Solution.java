package _669_trim_a_binary_search_tree;

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
 * If lower than low, return right & if higher than high return left
 * Time: O(N)
 * Space: O(H)
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        int val = root.val;
        if (val < low) return trimBST(root.right, low, high);
        if (val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
