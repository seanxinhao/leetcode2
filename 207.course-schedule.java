/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[][] graph = new int[n][n];
        for (int[] pair : prerequisites) {
            graph[pair[0]][pair[1]] = 1;
        }
        int[] track = new int[n]; // 0 - unknown, 1 - visiting, 2 - visited
        for (int i = 0; i < n; i++) {
            if (track[i] != 2 && !dfs(graph, track, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] track, int i) {
        int n = graph.length;
        track[i] = 1;
        for (int j = 0; j < n; j++) {
            if (graph[i][j] == 1 && track[j] != 2) {
                if (track[j] == 1 || !dfs(graph, track, j)) {
                    return false;
                }
            }
        }
        track[i] = 2;
        return true;
    }
}
// @lc code=end
