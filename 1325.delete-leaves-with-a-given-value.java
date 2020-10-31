/*
 * @lc app=leetcode id=1325 lang=java
 *
 * [1325] Delete Leaves With a Given Value
 */

// @lc code=start
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        TreeNode newLeft = removeLeafNodes(root.left, target);
        TreeNode newRight = removeLeafNodes(root.right, target);
        if (newLeft == null && newRight == null && root.val == target) {
            return null;
        }
        root.left = newLeft;
        root.right = newRight;
        return root;
    }
}
// @lc code=end
