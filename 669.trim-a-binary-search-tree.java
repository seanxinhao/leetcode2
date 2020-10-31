/*
 * @lc app=leetcode id=669 lang=java
 *
 * [669] Trim a Binary Search Tree
 */

// @lc code=start
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        TreeNode newLeft = trimBST(root.left, low, high);
        TreeNode newRight = trimBST(root.right, low, high);
        if (root.val < low || root.val > high) {
            if (newLeft != null && newRight != null) {
                throw new IllegalStateException();
            }
            if (newLeft != null) {
                return newLeft;
            }
            if (newRight != null) {
                return newRight;
            }
            if (newLeft == null && newRight == null) {
                return null;
            }
        }
        root.left = newLeft;
        root.right = newRight;
        return root;
    }
}
// @lc code=end
