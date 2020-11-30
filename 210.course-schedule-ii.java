import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[][] graph = new int[n][n];

        for (int[] pair : prerequisites) {
            graph[pair[0]][pair[1]] = 1;
        }

        int[] visited = new int[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (!dfs(graph, visited, i, ans)) {
                    return new int[0];
                }
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private boolean dfs(int[][] graph, int[] visited, int i, List<Integer> ans) {
        int n = graph.length;
        visited[i] = 1;
        for (int j = 0; j < n; j++) {
            if (graph[i][j] == 1 && visited[j] != 2) {
                if (visited[j] == 1 || !dfs(graph, visited, j, ans)) {
                    visited[i] = 0;
                    return false;
                }
            }
        }
        visited[i] = 2;
        ans.add(i);
        return true;
    }
}
// @lc code=end
