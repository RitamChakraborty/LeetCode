package _235_lowest_common_ancestor_of_a_binary_search_tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    /**
     * Imagine it's a binary search so based on the min & max value among p and q, traverse the tree.
     * And hoist the matching node up the tree, so that it doesn't catch the upper nodes as answer.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        int val = root.val;
        int pVal = p.val;
        int qVal = q.val;
        int min = Integer.min(pVal, qVal);
        int max = Integer.max(pVal, qVal);
        if (val >= min && val <= max) return root;
        if (val < min) return lowestCommonAncestor(root.right, p, q);
        if (val > max) return lowestCommonAncestor(root.left, p, q);
        return null;
    }
}
