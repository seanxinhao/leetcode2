/*
 * @lc app=leetcode id=1319 lang=java
 *
 * [1319] Number of Operations to Make Network Connected
 */

// @lc code=start
class Solution {
    public int makeConnected(int n, int[][] connections) {
        UnionFindSet ufs = new UnionFindSet(n);
        int cableLeft = 0;
        for (int[] connection : connections) {
            if (ufs.union(connection[0], connection[1])) {
                cableLeft++;
            }
        }
        // Note that unconnected computers could also connect to each other.
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            visited.add(ufs.find(i));
        }
        int cableNeeded = visited.size() - 1;
        if (cableNeeded > cableLeft) {
            return -1;
        }
        return cableNeeded;
    }

    class UnionFindSet {
        private int[] parent;

        public UnionFindSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int n) {
            if (parent[n] == n) {
                return n;
            } else {
                return find(parent[n]);
            }
        }

        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                parent[pb] = pa;
                return false;
            }
            return true;
        }
    }
}
// @lc code=end
