import java.util.Arrays;

/*
 * @lc app=leetcode id=877 lang=java
 *
 * [877] Stone Game
 */

// @lc code=start
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        // dp[i][j] , whether Alex wins with stones in sub-array [i, j] of piles.
        // dp[i][j] = true when i == j or i + 1 == j
        // dp[i][j] = dp[i + 1][j - 1] (Alex and Lee took two ends)
        // || dp[i + 2][j] (Alex took first, Lee took the first of the rest)
        // || dp[i][j - 2] (Alex took the last, Lee took the last of the rest)

        // traverse from small to large
        for (int length = 2; length < n; length++) {
            for (int start = 0; start + length < n; start++) {
                int i = start;
                int j = start + length;
                dp[i][j] = dp[i + 1][j - 1] || dp[i + 2][j] || dp[i][j - 2];
            }
        }

        return dp[0][n - 1];
    }
}
// @lc code=end
