package _100_same_tree;

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
 * Recursive DFS: Make sure the value between p and q are equal
 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }
}
