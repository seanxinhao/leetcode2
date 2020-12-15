/*
 * @lc app=leetcode id=685 lang=java
 *
 * [685] Redundant Connection II
 */

// @lc code=start
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        Arrays.fill(parent, 0);
        int[] edge1 = null;
        int[] edge2 = null;

        // Review first time for who causes in-degree = 2.
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (parent[to] != 0) {
                // if two in-degree, two removing candidates.
                edge1 = new int[] { parent[to], to };
                edge2 = new int[] { edge[0], edge[1] };
                // removing edge2 as an attempt.
                edge[0] = edge[1] = 0;
            } else {
                parent[to] = from;
            }
        }

        // Review the graph 2nd time for cycle.
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        // edge2 is not the right one to be removed, if cycle is still there.
        for (int[] edge : edges) {
            if (edge[0] == 0) {
                continue;
            }
            int from = edge[0];
            int to = edge[1];
            int pfrom = find(parent, from);
            int pto = find(parent, to);
            if (pfrom == pto) {
                return edge1 == null ? edge : edge1;
            } else {
                parent[pfrom] = pto;
            }
        }
        return edge2;
    }

    private int find(int[] parent, int n) {
        if (parent[n] == n) {
            return n;
        } else {
            return find(parent, parent[n]);
        }
    }
}
// @lc code=end
