import java.util.Arrays;

/*
 * @lc app=leetcode id=1210 lang=java
 *
 * [1210] Minimum Moves to Reach Target with Rotations
 */

// @lc code=start
class Solution {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int infinite = n * n + 1;
        int[][] dpH = new int[n + 1][n + 1]; // right facing tail position min moves.
        int[][] dpV = new int[n + 1][n + 1]; // down facing tail position min moves.
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dpH[i], infinite);
            Arrays.fill(dpV[i], infinite);
        }

        dpH[0][1] = -1;
        dpH[1][0] = -1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    continue;
                }
                // Horizontal move.
                if (j + 1 <= n && grid[i - 1][j] != 1) {
                    dpH[i][j] = Math.min(dpH[i - 1][j], dpH[i][j - 1]) + 1;
                }
                // Veritical move.
                if (i + 1 <= n && grid[i][j - 1] != 1) {
                    dpV[i][j] = Math.min(dpV[i - 1][j], dpV[i][j - 1]) + 1;
                }
                // Rotate.
                if (i + 1 <= n && j + 1 <= n && grid[i][j - 1] != 1 && grid[i][j] != 1) {
                    dpV[i][j] = Math.min(dpH[i][j] + 1, dpV[i][j]);
                }
                // Clockwise rotate.
                if (i + 1 <= n && j + 1 <= n && grid[i - 1][j] != 1 && grid[i][j] != 1) {
                    dpH[i][j] = Math.min(dpH[i][j], dpV[i][j] + 1);
                }
            }
        }

        return dpH[n][n - 1] >= infinite ? -1 : dpH[n][n - 1];
    }
}
// @lc code=end
