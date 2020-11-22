import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=741 lang=java
 *
 * [741] Cherry Pickup
 */

// @lc code=start
class Solution {
    int[][][][] dp;
    int[][] grid;
    int n;

    public int cherryPickup(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;

        // Two dp, one for com and one for back, is not working because:
        // optimal solution for coming route doesn't always infer optimal solution of
        // coming and back.

        // Key point:
        // from (0, 0) to (n - 1, n - 1) is equivalent with from (n - 1, n - 1) to (0,
        // 0)
        // Convert the problem to
        // Two points starts from (0, 0) and pick cherries, one cherries can
        // only be picked by one of them
        // count all cherries when two arrive (n - 1, n - 1)

        this.dp = new int[n][n][n][n];
        // dp[i][j][x][y] = Math.max(dp[i - 1][j][x - 1][y], dp[i - 1][j][x][y - 1],
        // dp[i][j - 1][x - 1][y], dp[i][j - 1][x][y - 1]) + grid[i][j]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Arrays.fill(dp[i][k][j], Integer.MIN_VALUE);
                }
            }
        }

        return Math.max(0, helper(n - 1, n - 1, n - 1, n - 1));
    }

    private int helper(int i, int j, int x, int y) {
        if (i < 0 || j < 0 || x < 0 || y < 0) {
            return -1;
        }
        if (grid[i][j] == -1 || grid[x][y] == -1) {
            return -1;
        }
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (dp[i][j][x][y] != Integer.MIN_VALUE) {
            return dp[i][j][x][y];
        }
        int ans = IntStream.of(helper(i - 1, j, x - 1, y), helper(i - 1, j, x, y - 1), helper(i, j - 1, x - 1, y),
                helper(i, j - 1, x, y - 1)).max().getAsInt();
        if (ans < 0) {
            ans = -1;
        } else {
            if (i == x && j == y) {
                ans += grid[i][j];
            } else {
                ans += grid[i][j] + grid[x][y];
            }
        }
        dp[i][j][x][y] = ans;
        return ans;
    }

}
// @lc code=end
