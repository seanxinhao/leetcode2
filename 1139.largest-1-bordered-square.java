/*
 * @lc app=leetcode id=1139 lang=java
 *
 * [1139] Largest 1-Bordered Square
 */

// @lc code=start
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = grid[i][0];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int area = 0;
                if (dp[i][j] >= 2) {
                    int maxLength = dp[i][j];
                    for (int l = 2; l <= maxLength; l++) {
                        if (i + 1 < l || j + 1 < l) {
                            break;
                        }
                        boolean match = true;
                        for (int k = 2; k < l; k++) {
                            if (dp[i - k + 1][j] == 0 || dp[i - k + 1][j - l + 1] == 0) {
                                match = false;
                                break;
                            }
                        }
                        if (match && dp[i - l + 1][j] >= l) {
                            area = l * l;
                        }
                    }
                } else {
                    area = dp[i][j];
                }
                max = Math.max(max, area);
            }
        }
        return max;
    }
}
// @lc code=end
