import java.util.Arrays;

/*
 * @lc app=leetcode id=1278 lang=java
 *
 * [1278] Palindrome Partitioning III
 */

// @lc code=start
class Solution {
    int[][] palindromeReplaceNum;
    String s;

    public int palindromePartition(String s, int k) {
        int n = s.length();

        this.s = s;
        palindromeReplaceNum = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(palindromeReplaceNum[i], -1);
        }
        for (int i = n - 1; i >= 0; i--) {
            palindromeReplaceNumHelper(0, i);
        }
        for (int i = 0; i < n; i++) {
            palindromeReplaceNumHelper(i, n - 1);
        }

        int[][] dp = new int[k][n];

        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = palindromeReplaceNum[0][j];
        }

        for (int i = 1; i < k; i++) {
            for (int j = i; j < n; j++) {
                for (int l = i - 1; l < j; l++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][l] + palindromeReplaceNum[l + 1][j]);
                }
                if (dp[i][j] == Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[k - 1][n - 1];
    }

    private int palindromeReplaceNumHelper(int i, int j) {
        if (i > j || i >= s.length() || j < 0) {
            return 0;
        }
        if (palindromeReplaceNum[i][j] != -1) {
            return palindromeReplaceNum[i][j];
        }
        int inner = palindromeReplaceNumHelper(i + 1, j - 1);
        int ans = s.charAt(i) == s.charAt(j) ? inner : inner + 1;
        palindromeReplaceNum[i][j] = ans;
        return ans;
    }
}
// @lc code=end
