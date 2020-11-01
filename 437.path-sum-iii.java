/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 */

// @lc code=start
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return traverse(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    // Path through root.
    public int traverse(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == sum) {
            count++;
        }
        count += traverse(root.left, sum - root.val) + traverse(root.right, sum - root.val);
        return count;
    }
}
// @lc code=end
