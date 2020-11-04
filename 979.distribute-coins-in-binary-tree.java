/*
 * @lc app=leetcode id=979 lang=java
 *
 * [979] Distribute Coins in Binary Tree
 */

// @lc code=start
class Solution {
    private int steps = 0;

    public int distributeCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }
        bottomUp(root);
        return steps;
    }

    private int bottomUp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = bottomUp(root.left);
        int r = bottomUp(root.right);
        int moves = Math.abs(l) + Math.abs(r);
        steps += moves;
        return l + r + root.val - 1;
    }
}
// @lc code=end
