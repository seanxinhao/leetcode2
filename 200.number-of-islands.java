/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    visit(grid, m, n, visited, i, j);
                }
            }
        }

        return count;
    }

    private void visit(char[][] grid, int m, int n, boolean[][] visited, int i, int j) {
        if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] != '0' && !visited[i][j]) {
            visited[i][j] = true;
            visit(grid, m, n, visited, i - 1, j);
            visit(grid, m, n, visited, i, j - 1);
            visit(grid, m, n, visited, i + 1, j);
            visit(grid, m, n, visited, i, j + 1);
        }
    }
}
// @lc code=end
