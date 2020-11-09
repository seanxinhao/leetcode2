/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (j - 1 >= 0 ? dp[i][j - 1] : 0) + 1;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int width = Integer.MAX_VALUE;
                for (int k = i; k < m; k++) {
                    width = Math.min(width, dp[k][j]);
                    if (width == 0) {
                        break;
                    }
                    int height = k - i + 1;
                    maxArea = Math.max(maxArea, height * width);
                }
            }
        }

        return maxArea;
    }
}
// @lc code=end
