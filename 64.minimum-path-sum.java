import java.util.Arrays;

/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] sum = new int[m + 1][n + 1];
        sum[1][1] = grid[0][0];

        for (int i = 0; i <= m; i++) {
            sum[i][0] = Integer.MAX_VALUE;
        }
        Arrays.fill(sum[0], Integer.MAX_VALUE);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                int num = grid[i - 1][j - 1];
                sum[i][j] += Math.min(sum[i - 1][j], sum[i][j - 1]) + num;
            }
        }

        return sum[m][n];
    }
}
// @lc code=end
