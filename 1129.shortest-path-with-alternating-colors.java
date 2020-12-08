/*
 * @lc app=leetcode id=1129 lang=java
 *
 * [1129] Shortest Path with Alternating Colors
 */

// @lc code=start
class Solution {
    private int[][] mem;

    // DFS could be better solution for min path.
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        mem = new int[2][n];
        Arrays.fill(mem[0], -1);
        Arrays.fill(mem[1], -1);
        // 0 -- red;
        // 1 -- blue;
        int[][] redGraph = new int[n][n];
        for (int[] edge : red_edges) {
            int from = edge[0];
            int to = edge[1];
            redGraph[from][to] = 1;
        }
        int[][] blueGraph = new int[n][n];
        for (int[] edge : blue_edges) {
            int from = edge[0];
            int to = edge[1];
            blueGraph[from][to] = 1;
        }
        dfs(redGraph, blueGraph, 0, 0, 0);
        dfs(blueGraph, redGraph, 1, 0, 0);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (mem[0][i] == -1 && mem[1][i] == -1) {
                ans[i] = -1;
            } else {
                int a = mem[0][i] == -1 ? Integer.MAX_VALUE : mem[0][i];
                int b = mem[1][i] == -1 ? Integer.MAX_VALUE : mem[1][i];
                ans[i] = Math.min(a, b);
            }
        }
        return ans;
    }

    private void dfs(int[][] firstGraph, int[][] secondGraph, int color, int curr, int path) {
        if (mem[color][curr] != -1 && path >= mem[color][curr]) {
            return;
        }
        mem[color][curr] = path;
        int n = firstGraph.length;
        for (int j = 0; j < n; j++) {
            if (firstGraph[curr][j] == 1) {
                dfs(secondGraph, firstGraph, (color + 1) % 2, j, path + 1);
            }
        }
    }
}
// @lc code=end
