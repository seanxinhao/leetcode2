/*
 * @lc app=leetcode id=1130 lang=java
 *
 * [1130] Minimum Cost Tree From Leaf Values
 */

// @lc code=start
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][n];
        // dp[i][j] is the ans of sub-array [i, j]
        // dp[i][j] = 0 when i == j
        // dp[i][j] = arr[i] * arr[j] when i + 1 == j
        // dp[i][j] = min{ dp[i][k] + dp[k + 1][j] + max[i...k] * max[k + 1...j] }
        // i <= k < j

        int[][] max = new int[n][n];
        for (int i = 0; i < n; i++) {
            int localMax = 0;
            for (int j = i; j < n; j++) {
                localMax = Math.max(localMax, arr[j]);
                max[i][j] = localMax;
                if (i + 1 == j) {
                    dp[i][j] = arr[i] * arr[j];
                }
            }
        }

        for (int length = 2; length < n; length++) {
            for (int start = 0; start + length < n; start++) {
                int i = start;
                int j = start + length;
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
                }
                dp[i][j] = min;
            }
        }

        return dp[0][n - 1];
    }
}
// @lc code=end
