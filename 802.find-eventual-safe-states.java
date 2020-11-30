/*
 * @lc app=leetcode id=802 lang=java
 *
 * [802] Find Eventual Safe States
 */

// @lc code=start
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] visited = new int[n];
            if (dfs(graph, visited, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean dfs(int[][] graph, int[] visited, int i) {
        if (visited[i] == 1) { // visited
            return false;
        }
        visited[i] = 1; // visiting
        for (int j : graph[i]) {
            if (visited[j] != 2) {
                if (!dfs(graph, visited, j)) {
                    return false;
                }
            }
        }
        visited[i] = 2;
        return true;
    }
}
// @lc code=end
