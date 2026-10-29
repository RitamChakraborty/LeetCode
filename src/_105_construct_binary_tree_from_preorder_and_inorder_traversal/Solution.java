package _105_construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * In the preOrder array the first index is always the root. Find the index of first element in the inOrder array.
 * That index is the intersection point of the left subtree and the right subtree of the root node.
 * Just like merge/quick sort, recursively do the same operation on the left subtree and the right subtree
 */
class Solution {
    private Map<Integer, Integer> inorderMap;

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd) {
        // Base case: if start pointers cross end pointers, subtree is empty
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder is the root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the root's index in inorder using our map (O(1) lookup)
        int mid = inorderMap.get(rootVal);

        // Calculate the number of elements in the left subtree
        int leftSubtreeSize = mid - inStart;

        // Recursively build left and right subtrees
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize,
                inorder, inStart, mid - 1);

        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd,
                inorder, mid + 1, inEnd);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        // Pre-populate map for O(1) index lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}