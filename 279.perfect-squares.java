/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        double sqrt = Math.sqrt(n);
        double floor = Math.floor(sqrt);
        if (sqrt == floor) {
            return 1;
        }
        int m = (int) floor;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = n + 1;
            for (int j = 1; j <= m; j++) {
                int diff = i - j * j;
                if (diff < 0) {
                    break;
                }
                min = Math.min(min, dp[diff] + 1);
            }
            dp[i] = min;
        }

        return dp[n];
    }
}
// @lc code=end
