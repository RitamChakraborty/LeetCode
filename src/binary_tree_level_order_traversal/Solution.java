package binary_tree_level_order_traversal;

import java.util.*;

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

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> res = new LinkedList<>();

        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode n = queue.peek();

                if (n != null) {
                    if (n.left != null) queue.add(n.left);
                    if (n.right != null) queue.add(n.right);
                }

                list.add(Objects.requireNonNull(queue.poll()).val);
            }

            res.add(list);
        }

        return res;
    }
}