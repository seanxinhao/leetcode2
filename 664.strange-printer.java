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

        // For "abba", divded into "a" and "bba"
        // If print "a" and print "bba", not optimal (dp[i][k] + dp[k + 1][j])
        // Optimal: print "aaaa" and print "bb" (dp[i][k] + dp[k + 1][j - 1]) when s[k]
        // == s[j]
        //
        // dp[i][j] means count of substring [i, j]
        // dp[i][j] = 1 when i == j
        // dp[i][j] = min{ dp[i][k] + dp[k + 1][j] } when i < k < j and s[k] != s[j]
        // dp[i][j] = min{ dp[i][k] + dp[k + 1][j - 1] } when i < k < j and s[k] == s[j]
        //
        // warning: greedy from two ends cannot cover all cases.

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int length = 1; length < n; length++) {
            for (int start = 0; start + length < n; start++) {
                int i = start;
                int j = start + length;
                dp[i][j] = length + 1;
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j - 1]);
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
// @lc code=end
