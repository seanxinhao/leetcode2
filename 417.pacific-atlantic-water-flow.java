import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return ans;
        }
        int n = matrix[0].length;
        // Start the BFS from edge. TLE otherwise
        Deque<int[]> pacificQ = new ArrayDeque<>();
        Deque<int[]> altlanticQ = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pacificQ.addLast(new int[] { i, j });
                }
                if (i == m - 1 || j == n - 1) {
                    altlanticQ.addLast(new int[] { i, j });
                }
            }
        }
        boolean[][] pacificVisited = bfs(pacificQ, matrix);
        boolean[][] altlanticVisited = bfs(altlanticQ, matrix);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && altlanticVisited[i][j]) {
                    List<Integer> a = new ArrayList<>();
                    a.add(i);
                    a.add(j);
                    ans.add(a);
                }
            }
        }
        return ans;
    }

    private boolean[][] bfs(Deque<int[]> q, int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        boolean[][] visited = new boolean[m][n];
        while (!q.isEmpty()) {
            int[] curr = q.removeFirst();
            int i = curr[0];
            int j = curr[1];
            visited[i][j] = true;
            for (int[] direction : directions) {
                int ni = i + direction[0];
                int nj = j + direction[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] >= matrix[i][j] && !visited[ni][nj]) {
                    q.addLast(new int[] { ni, nj });
                }
            }
        }
        return visited;
    }
}
// @lc code=end
