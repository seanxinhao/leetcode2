import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=827 lang=java
 *
 * [827] Making A Large Island
 */

// @lc code=start
class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited1 = new boolean[m][n];
        boolean[][] visited2 = new boolean[m][n];
        Map<Integer, Integer> areaMap = new HashMap<>();
        areaMap.put(0, 0);

        int max = 0;
        int count = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int area = visit(grid, visited1, i, j);
                max = Math.max(max, area);
                areaMap.put(count, area);
                fill(grid, visited2, i, j, count);
                count++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    List<Integer> counts = new ArrayList<>();
                    counts.add(i - 1 >= 0 ? grid[i - 1][j] : 0);
                    counts.add(j - 1 >= 0 ? grid[i][j - 1] : 0);
                    counts.add(i + 1 < m ? grid[i + 1][j] : 0);
                    counts.add(j + 1 < n ? grid[i][j + 1] : 0);
                    max = Math.max(max,
                            counts.stream().distinct().map(c -> areaMap.get(c)).reduce((a, b) -> a + b).get() + 1);
                }
            }
        }

        return max;
    }

    private int visit(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;

        int up = visit(grid, visited, i - 1, j);
        int left = visit(grid, visited, i, j - 1);
        int down = visit(grid, visited, i + 1, j);
        int right = visit(grid, visited, i, j + 1);

        return up + left + down + right + 1;
    }

    private void fill(int[][] grid, boolean[][] visited, int i, int j, int area) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        grid[i][j] = area;
        fill(grid, visited, i - 1, j, area);
        fill(grid, visited, i, j - 1, area);
        fill(grid, visited, i + 1, j, area);
        fill(grid, visited, i, j + 1, area);
    }
}
// @lc code=end
