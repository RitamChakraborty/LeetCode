package _113_path_sum_ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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
    private void pathSum(TreeNode node, int sum, int targetSum, ArrayDeque<Integer> queue, List<List<Integer>> list) {
        if (node != null) {
            sum += node.val;

            if (node.left != null && node.right != null) {
                if (sum == targetSum) {
                    queue.add(node.val);
                    list.add(new ArrayList<>(queue));
                    queue.removeLast();
                }
            } else {
                queue.add(node.val);
                pathSum(node.left, sum, targetSum, queue, list);
                pathSum(node.right, sum, targetSum, queue, list);
                queue.removeLast();
            }
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        pathSum(root, 0, targetSum, new ArrayDeque<>(), list);
        return list;
    }
}