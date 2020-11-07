import java.util.Arrays;

/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][];
        for (int i = 0; i <= coins.length; i++) {
            dp[i] = new int[amount + 1];
            Arrays.fill(dp[i], 0);
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int sum = 1; sum <= amount; sum++) {
                if (sum - coins[i - 1] >= 0) {
                    dp[i][sum] = dp[i][sum - coins[i - 1]] + dp[i - 1][sum];
                } else {
                    dp[i][sum] = dp[i - 1][sum];
                }
            }
        }

        return dp[coins.length][amount];
    }
}
// @lc code=end
