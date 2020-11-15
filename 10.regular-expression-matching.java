/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();

        boolean[][] dp = new boolean[l1 + 1][l2 + 1];

        dp[0][0] = true;

        for (int j = 1; j <= l2; j++) {
            char pc = p.charAt(j - 1);
            if (pc == '*') {
                dp[0][j] = dp[0][j - 2];
            } else {
                dp[0][j] = false;
            }
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1]; // match exact char.
                } else if (pc == '*' && j - 2 >= 0) { // meet wildcard.
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == sc) { // match wildcard.
                        // Check three cases:
                        // 1. Without char - wildcard matches 1+
                        // 2. Without wildcard - wildcard matches 0
                        // 3. Without both - wildcard matches 1
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2] || dp[i - 1][j - 2];
                    } else {
                        // Wildcard matches 0
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[l1][l2];
    }
}
// @lc code=end
