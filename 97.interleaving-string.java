/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        boolean[][][] dp = new boolean[l1 + 1][l2 + 1][l3 + 1];
        // Whether s1[0...i] and s2[0...i] is interleaving of s3[0...j]

        dp[0][0][0] = true;

        for (int i = 1; i <= l1; i++) {
            for (int k = 1; k <= l3; k++) {
                if (k <= i) {
                    dp[i][0][k] = s1.charAt(i - 1) == s3.charAt(k - 1) && dp[i - 1][0][k - 1];
                }
            }
        }

        for (int j = 1; j <= l2; j++) {
            for (int k = 1; k <= l3; k++) {
                if (k <= j) {
                    dp[0][j][k] = s2.charAt(j - 1) == s3.charAt(k - 1) && dp[0][j - 1][k - 1];
                }
            }
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                for (int k = 1; k <= l3; k++) {
                    if (i + j <= k) {
                        if (s1.charAt(i - 1) == s3.charAt(k - 1)) {
                            dp[i][j][k] = dp[i][j][k] || dp[i - 1][j][k - 1];
                        }
                        if (s2.charAt(j - 1) == s3.charAt(k - 1)) {
                            dp[i][j][k] = dp[i][j][k] || dp[i][j - 1][k - 1];
                        }
                    }
                }
            }
        }

        return dp[l1][l2][l3];
    }
}
// @lc code=end
