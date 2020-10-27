import java.util.Arrays;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][];
        for (int i = 0; i < m; i++) {
            ans[i] = new int[n];
            // Note that the ans[i][j] could be used for plus one. Minus 1 to avoid
            // overflow.
            Arrays.fill(ans[i], Integer.MAX_VALUE - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    ans[i][j] = 0;
                } else {
                    if (i >= 1) {
                        ans[i][j] = Math.min(ans[i - 1][j] + 1, ans[i][j]);
                    }
                    if (j >= 1) {
                        ans[i][j] = Math.min(ans[i][j - 1] + 1, ans[i][j]);
                    }
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    ans[i][j] = 0;
                } else {
                    if (i + 1 < m) {
                        ans[i][j] = Math.min(ans[i + 1][j] + 1, ans[i][j]);
                    }
                    if (j + 1 < n) {
                        ans[i][j] = Math.min(ans[i][j + 1] + 1, ans[i][j]);
                    }
                }
            }
        }

        return ans;
    }
}
// @lc code=end
