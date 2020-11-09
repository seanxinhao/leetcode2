/*
 * @lc app=leetcode id=1277 lang=java
 *
 * [1277] Count Square Submatrices with All Ones
 */

// @lc code=start
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = (j - 1 >= 0 ? dp[i][j - 1] : 0) + 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > 0) {
                    int width = Integer.MAX_VALUE;
                    for (int k = i; k < m; k++) {
                        width = Math.min(width, dp[k][j]);
                        int height = k - i + 1;
                        if (height <= width) {
                            count++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return count;
    }
}
// @lc code=end
