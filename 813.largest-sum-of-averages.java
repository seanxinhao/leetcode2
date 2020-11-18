/*
 * @lc app=leetcode id=813 lang=java
 *
 * [813] Largest Sum of Averages
 */

// @lc code=start
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;

        double[][] dp = new double[K][n];
        double[] sums = new double[n];

        dp[0][0] = A[0];
        sums[0] = A[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + A[i];
            dp[0][i] = sums[i] / (i + 1);
        }

        for (int i = 1; i < K; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i - 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + (sums[j] - sums[k]) / (j - k));
                }
            }
        }

        return dp[K - 1][n - 1];
    }
}
// @lc code=end
