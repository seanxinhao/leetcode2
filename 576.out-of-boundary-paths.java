/*
 * @lc app=leetcode id=576 lang=java
 *
 * [576] Out of Boundary Paths
 */

// @lc code=start
class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int bound = (int) 1e9 + 7;
        int[][][] dp = new int[N + 1][m][n];

        for (int nc = 1; nc <= N; nc++) {
            for (int ic = 0; ic < m; ic++) {
                for (int jc = 0; jc < n; jc++) {
                    int sum = 0;
                    sum += ic > 0 ? dp[nc - 1][ic - 1][jc] : (nc == 1 ? 1 : 0);
                    sum %= bound;
                    sum += jc > 0 ? dp[nc - 1][ic][jc - 1] : (nc == 1 ? 1 : 0);
                    sum %= bound;
                    sum += ic < m - 1 ? dp[nc - 1][ic + 1][jc] : (nc == 1 ? 1 : 0);
                    sum %= bound;
                    sum += jc < n - 1 ? dp[nc - 1][ic][jc + 1] : (nc == 1 ? 1 : 0);
                    sum %= bound;
                    dp[nc][ic][jc] = sum;
                }
            }
        }

        int sum = 0;
        for (int nc = 1; nc <= N; nc++) {
            sum += dp[nc][i][j];
            sum %= bound;
        }
        return sum;
    }
}
// @lc code=end
