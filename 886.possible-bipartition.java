/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

// @lc code=start
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        for (int[] dislike : dislikes) {
            graph[dislike[0] - 1][dislike[1] - 1] = 1;
            graph[dislike[1] - 1][dislike[0] - 1] = 1;
        }
        int[] color = new int[N];
        for (int i = 0; i < N; i++) {
            if (color[i] == 0 && !coloring(graph, color, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean coloring(int[][] graph, int[] color, int c, int node) {
        if (color[node] != 0) {
            return color[node] == c;
        }
        color[node] = c;
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            if (i != node && graph[node][i] == 1) {
                if (!coloring(graph, color, -c, i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
