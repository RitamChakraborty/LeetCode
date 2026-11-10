package _572_subtree_of_another_tree;

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
 * Recursive DFS: Check is same tree or not other recursively check left subtree or right subtree
 * Time: O(M X N)
 * Space: O(H)
 */
class Solution {
    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        return (a.val == b.val) && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return root == subRoot;
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
