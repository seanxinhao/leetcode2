/*
 * @lc app=leetcode id=882 lang=java
 *
 * [882] Reachable Nodes In Subdivided Graph
 */

// @lc code=start
class Solution {
    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        List<Edge> allEdges = new ArrayList();
        for (int[] edge : edges) {
            Edge edgeObj = new Edge(edge[0], edge[1], edge[2]);
            allEdges.add(edgeObj);
            List<Edge> val = graph.getOrDefault(edge[0], new ArrayList<>());
            val.add(edgeObj);
            graph.put(edge[0], val);
            val = graph.getOrDefault(edge[1], new ArrayList<>());
            val.add(edgeObj);
            graph.put(edge[1], val);
        }
        Map<Integer, Integer> leftMoveMap = new HashMap<>();
        leftMoveMap.put(0, M);
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        while (!q.isEmpty()) {
            int curr = q.removeFirst();
            int currLeftMove = leftMoveMap.get(curr);
            List<Edge> adjs = graph.getOrDefault(curr, new ArrayList());
            for (Edge adj : adjs) {
                int to = curr == adj.from ? adj.to : adj.from;
                if (currLeftMove > adj.nodeNum) {
                    adj.fullVisited();
                    int leftMove = currLeftMove - (adj.nodeNum + 1);
                    if (leftMove > leftMoveMap.getOrDefault(to, Integer.MIN_VALUE)) {
                        leftMoveMap.put(to, leftMove);
                        q.addLast(to);
                    }
                } else {
                    adj.partialVisited(curr, currLeftMove);
                }
            }
        }
        int counter = leftMoveMap.keySet().size();
        for (Edge edge : allEdges) {
            counter += edge.getVisitedNum();
        }
        return counter;
    }

    class Edge {
        int from;
        int to;
        int fromVisited;
        int toVisited;
        int nodeNum;

        public Edge(int from, int to, int nodeNum) {
            this.from = from;
            this.to = to;
            this.nodeNum = nodeNum;
        }

        public void partialVisited(int direction, int visitedNum) {
            if (direction == from) {
                fromVisited = visitedNum;
            } else if (direction == to) {
                toVisited = visitedNum;
            }
        }

        public void fullVisited() {
            fromVisited = toVisited = nodeNum;
        }

        public int getVisitedNum() {
            int sum = fromVisited + toVisited;
            return Math.min(sum, nodeNum);
        }
    }
}
// @lc code=end
