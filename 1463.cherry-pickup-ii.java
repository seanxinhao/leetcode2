/*
 * @lc app=leetcode id=1463 lang=java
 *
 * [1463] Cherry Pickup II
 */

// @lc code=start
class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        // dp[i][j][k] = max{ dp[i + 1][(j + 1, j, j - 1)][(k + 1, k, k - 1)] + grid[i][j] + (grid[i][k] (when k != j)) }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = grid[i][j] + (j != k ? grid[i][k] : 0);
                    if (i != m - 1) {
                        int max = 0;
                        for (int x = -1; x <= 1; x++) {
                            for (int y = -1; y <= 1; y++) {
                                int xj = j + x;
                                int yk = k + y;
                                if (xj >= 0 && xj < n && yk >= 0 && yk < n) {
                                    max = Math.max(max, dp[i + 1][xj][yk]);
                                }
                            }
                        }
                        dp[i][j][k] += max;
                    }
                }
            }
        }

        return dp[0][0][n - 1];
    }
}
// @lc code=end
