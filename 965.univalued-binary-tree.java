/*
 * @lc app=leetcode id=965 lang=java
 *
 * [965] Univalued Binary Tree
 */

// @lc code=start
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftVal = (root.left == null ? root.val : root.left.val);
        int rightVal = (root.right == null ? root.val : root.right.val);
        return isUnivalTree(root.left) && isUnivalTree(root.right) && leftVal == rightVal && leftVal == root.val;
    }
}
// @lc code=end
