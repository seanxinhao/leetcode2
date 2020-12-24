/*
 * @lc app=leetcode id=847 lang=java
 *
 * [847] Shortest Path Visiting All Nodes
 */

// @lc code=start
class Solution {
    private int allVisited;

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        allVisited = (1 << n) - 1;

        Deque<State> q = new ArrayDeque<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            State s = new State(i);
            q.addLast(s);
            set.add(s.toString());

        }

        int counter = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                State curr = q.removeFirst();
                if (curr.getVisited() == allVisited) {
                    return counter;
                }
                for (int adj : graph[curr.node]) {
                    State next = curr.copy();
                    next.setNode(adj);
                    next.visit(adj);
                    if (!set.contains(next.toString())) {
                        q.addLast(next);
                        set.add(next.toString());
                    }
                }
            }
            counter++;
        }

        return -1;
    }

    class State {
        int visited;
        int node;

        public State(int n) {
            this.node = n;
            this.visited = 0;
            this.visit(n);
        }

        public int getVisited() {
            return visited;
        }

        public void visit(int n) {
            visited |= 1 << n;
        }

        public void setNode(int n) {
            this.node = n;
        }

        public State copy() {
            State s = new State(0);
            s.visited = this.visited;
            s.node = this.node;
            return s;
        }

        public String toString() {
            return visited + "," + node;
        }
    }
}
// @lc code=end
