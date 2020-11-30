import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1462 lang=java
 *
 * [1462] Course Schedule IV
 */

// @lc code=start
class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[][] graph = new int[n][n];
        for (int[] pair : prerequisites) {
            graph[pair[0]][pair[1]] = 1;
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            boolean[] visited = new boolean[n];
            ans.add(dfs(graph, visited, query[0], query[1]));
        }
        return ans;
    }

    public boolean dfs(int[][] graph, boolean[] visited, int s, int d) {
        if (s == d) {
            return true;
        }
        int n = graph.length;
        visited[s] = true;
        for (int i = 0; i < n; i++) {
            if (graph[s][i] == 1 && !visited[i]) {
                if (dfs(graph, visited, i, d)) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end
