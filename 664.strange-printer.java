/*
 * @lc app=leetcode id=664 lang=java
 *
 * [664] Strange Printer
 */

// @lc code=start
class Solution {
    public int strangePrinter(String s) {
        int n = s.length();

        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][n];

        // dp[i][j] means count of substring [i, j]
        // dp[i][j] = 1 when i == j
        // dp[i][j] = dp[x][y] + 1 when s[i..x] == s[y..j]
        // dp[i][j] = min{ dp[x][j] + 1, dp[i][y] + 1 }
        // when s[i..x] are same and s[y..j] are same but s[i] != s[j]

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int length = 1; length < n; length++) {
            for (int start = 0; start + length < n; start++) {
                int i = start;
                int j = start + length;
                if (s.charAt(i) == s.charAt(i + 1) || s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j] + 1;
                }
                if (s.charAt(j) == s.charAt(j - 1) || s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }

        return dp[0][n - 1];
    }
}
// @lc code=end
