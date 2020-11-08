/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] map = new int[m + 1][n + 1];

        map[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1 || i == 1 && j == 1) {
                    continue;
                }
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }

        return map[m][n];
    }
}
// @lc code=end
