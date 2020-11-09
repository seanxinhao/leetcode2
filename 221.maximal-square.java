/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
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
                if (matrix[i][j] == '1') {
                    dp[i][j] = (j - 1 >= 0 ? dp[i][j - 1] : 0) + 1;
                }
            }
        }

        int largestSquare = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > 0) {
                    int width = Integer.MAX_VALUE;
                    for (int k = i; k < m; k++) {
                        width = Math.min(width, dp[k][j]);
                        int height = k - i + 1;
                        if (height >= width) {
                            largestSquare = Math.max(largestSquare, width * width);
                            break;
                        }
                    }
                }
            }
        }

        return largestSquare;
    }
}
// @lc code=end
