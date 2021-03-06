/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start
class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            int solutions = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    solutions += dp[i - nums[j]];
                }
            }
            dp[i] = solutions;
        }
        return dp[target];
    }
}
// @lc code=end
