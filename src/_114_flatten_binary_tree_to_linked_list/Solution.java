package _114_flatten_binary_tree_to_linked_list;

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
     * Start form the node before the leaf and flatten it and return.
     * Make sure
     *
     * @param root
     * @return
     */
    private TreeNode inOrder (TreeNode root){
        if (root == null) return null;

        TreeNode left = inOrder(root.left);
        TreeNode right = inOrder(root.right);

        if (left != null) {
            TreeNode temp = left;

            // Going to the right edge of the left sub tree
            while (temp.right != null) {
                temp = temp.right;
            }

            temp.right = right;
            root.right = left;
        } else {
            root.right = right;
        }

        root.left = null;
        return root;
    }

    public void flatten (TreeNode root){
        inOrder(root);
    }
}