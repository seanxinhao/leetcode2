/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        return bfsSolution(edges);
    }

    private int[] bfsSolution(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int s = edge[0];
            int d = edge[1];
            Set<Integer> visited = new HashSet<>();
            if (connected(graph, s, d, visited)) {
                return edge;
            }
            List<Integer> adjs = graph.getOrDefault(s, new ArrayList<>());
            adjs.add(d);
            graph.put(s, adjs);
            adjs = graph.getOrDefault(d, new ArrayList<>());
            adjs.add(s);
            graph.put(d, adjs);
        }
        return new int[] {};
    }

    private boolean connected(Map<Integer, List<Integer>> graph, int s, int t, Set<Integer> visited) {
        if (s == t) {
            return true;
        }
        if (graph.containsKey(s) && graph.containsKey(t)) {
            List<Integer> neighbors = graph.get(s);
            visited.add(s);
            for (int neighbor : neighbors) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                if (connected(graph, neighbor, t, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] unionFindSolution(int[][] edges) {
        int n = edges.length;
        List<int[]> removed = new ArrayList<>();
        UnionFindSet ufs = new UnionFindSet(1001);
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            if (!ufs.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[] {};
    }

    class UnionFindSet {
        private int[] parents;

        public UnionFindSet(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int find(int n) {
            if (parents[n] == n) {
                return n;
            } else {
                return find(parents[n]);
            }
        }

        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                parents[pa] = pb;
                return true;
            } else {
                return false;
            }
        }
    }
}
// @lc code=end
