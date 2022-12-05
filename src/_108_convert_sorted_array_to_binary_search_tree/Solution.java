package _108_convert_sorted_array_to_binary_search_tree;

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
    private TreeNode add(int left, int right, int[] nums) {
        if (left <= right) {
            int mid = (right + left) / 2;
            TreeNode newNode = new TreeNode(nums[mid]);
            newNode.left = add(left, mid - 1, nums);
            newNode.right = add(mid + 1, right, nums);
            return newNode;
        }

        return null;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return add(0, nums.length - 1, nums);
    }
}