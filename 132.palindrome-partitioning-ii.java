/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        int n = s.length();

        boolean[][] palindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                palindrome[i][i + 1] = true;
                palindrome[i + 1][i] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            int j = 1;
            while (i + j < n && i - j >= 0) {
                palindrome[i - j][i + j] = s.charAt(i - j) == s.charAt(i + j) && palindrome[i - j + 1][i + j - 1];
                j++;
            }
        }

        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i + 1;
            while (l >= 0 && r < n) {
                palindrome[l][r] = s.charAt(l) == s.charAt(r) && palindrome[l + 1][r - 1];
                l--;
                r++;
            }
        }

        int[] dp = new int[n + 1];
        dp[0] = -1;

        for (int i = 1; i <= n; i++) {
            int min = dp[i - 1] + 1;
            for (int k = i; k >= 1; k--) {
                if (palindrome[k - 1][i - 1]) {
                    min = Math.min(min, dp[k - 1] + 1);
                }
            }
            dp[i] = min;
        }

        return dp[n];
    }
}
// @lc code=end
