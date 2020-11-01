/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
 */

// @lc code=start
class Solution {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return sum;
    }

    private void traverse(TreeNode root, int prev) {
        if (root == null) {
            return;
        }
        int next = prev * 10 + root.val;
        traverse(root.left, next);
        traverse(root.right, next);
        if (root.left == null && root.right == null) {
            sum += next;
        }
    }
}
// @lc code=end
