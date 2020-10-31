/*
 * @lc app=leetcode id=814 lang=java
 *
 * [814] Binary Tree Pruning
 */

// @lc code=start
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (sum(root.left) == 0) {
            root.left = null;
        }
        if (sum(root.right) == 0) {
            root.right = null;
        }
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        pruneTree(root.left);
        pruneTree(root.right);
        return root;
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }
}
// @lc code=end
