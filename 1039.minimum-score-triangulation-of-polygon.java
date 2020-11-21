/*
 * @lc app=leetcode id=1039 lang=java
 *
 * [1039] Minimum Score Triangulation of Polygon
 */

// @lc code=start
class Solution {
    public int minScoreTriangulation(int[] A) {
        int n = A.length;

        int[][] dp = new int[n][n];

        // dp[i][j] is the ans of sub-array [i, j] of A.
        // dp[i][j] = 0 when j - i < 2
        // dp[i][j] = min {A[i] * A[k] * A[j] + dp[i][k] + dp[k][j]} where i < k < j

        // traverse from small sub-array to large.

        for (int length = 2; length < n; length++) {
            for (int start = 0; start < n - length; start++) {
                int min = (int) 1e6;
                int i = start;
                int j = start + length;
                for (int k = i + 1; k < j; k++) {
                    min = Math.min(min, A[i] * A[k] * A[j] + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = min;
            }
        }

        return dp[0][n - 1];
    }
}
// @lc code=end
