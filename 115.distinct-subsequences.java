/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (i >= j) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        // before i, subseqs counts of t(i, j) is dp(i - 1, j)
                        // when i, subseqs of t(i, j) is the subseqs count of prefix t(i - 1, j - 1).
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[l1][l2];
    }
}
// @lc code=end
