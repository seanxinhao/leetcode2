/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    private int[][] cumulateArea;
    private int m;
    private int n;

    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        if (m == 0) {
            return;
        }
        n = matrix[0].length;
        if (n == 0) {
            return;
        }
        cumulateArea = new int[m + 1][n + 1];

        cumulateArea[1][1] = matrix[0][0];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cumulateArea[i][j] = cumulateArea[i - 1][j] + cumulateArea[i][j - 1] - cumulateArea[i - 1][j - 1]
                        + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return cumulateArea[row2 + 1][col2 + 1] - cumulateArea[row1][col2 + 1] - cumulateArea[row2 + 1][col1]
                + cumulateArea[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj
 * = new NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end
