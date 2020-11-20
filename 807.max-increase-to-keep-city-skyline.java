/*
 * @lc app=leetcode id=807 lang=java
 *
 * [807] Max Increase to Keep City Skyline
 */

// @lc code=start
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] maxm = new int[m];
        int[] maxn = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxm[i] = Math.max(maxm[i], grid[i][j]);
                maxn[j] = Math.max(maxn[j], grid[i][j]);
            }
        }

        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.min(maxm[i] - grid[i][j], maxn[j] - grid[i][j]);
            }
        }

        return sum;
    }
}
// @lc code=end
