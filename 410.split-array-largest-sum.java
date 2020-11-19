/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;

        int[][] sum = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    sum[i][j] = nums[j];
                } else {
                    sum[i][j] = sum[i][j - 1] + nums[j];
                }
            }
        }

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = sum[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = i; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i - 1; k < j; k++) {
                    min = Math.min(min, Math.max(dp[i - 1][k], sum[k + 1][j]));
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i][j] = min;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
// @lc code=end
