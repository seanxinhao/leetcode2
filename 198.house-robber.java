/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[2][n];
        dp[0][0] = 0;
        dp[1][0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[1][i] = dp[0][i - 1] + nums[i];
        }

        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
}
// @lc code=end
