import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        // DFS should also work, even faster.
        for (int k = 0; k < n; k++) {
            int[] color = new int[n];
            Deque<Integer> q = new ArrayDeque<>();
            q.addLast(k);
            int c = 1;
            while (!q.isEmpty()) {
                int s = q.size();
                for (int i = 0; i < s; i++) {
                    int node = q.removeFirst();
                    color[node] = c;
                    for (int adj : graph[node]) {
                        if (color[adj] == c) {
                            return false;
                        } else if (color[adj] == 0) {
                            q.addLast(adj);
                        }
                    }
                }
                if (c == 1) {
                    c = 2;
                } else {
                    c = 1;
                }
            }
        }

        return true;
    }
}
// @lc code=end
