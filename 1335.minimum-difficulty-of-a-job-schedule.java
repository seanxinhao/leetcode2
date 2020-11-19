/*
 * @lc app=leetcode id=1335 lang=java
 *
 * [1335] Minimum Difficulty of a Job Schedule
 */

// @lc code=start
class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) {
            return -1;
        }

        int[][] max = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    max[i][j] = jobDifficulty[j];
                } else {
                    max[i][j] = Math.max(max[i][j - 1], jobDifficulty[j]);
                }
            }
        }

        int[][] dp = new int[d][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = max[0][j];
        }

        for (int i = 1; i < d; i++) {
            for (int j = i; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i - 1; k < j; k++) {
                    min = Math.min(min, dp[i - 1][k] + max[k + 1][j]);
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i][j] = min;
                }
            }
        }

        return dp[d - 1][n - 1];
    }
}
// @lc code=end
