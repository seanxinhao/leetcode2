import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] time : times) {
            List<Edge> edges = graph.getOrDefault(time[0], new ArrayList<>());
            edges.add(new Edge(time[1], time[2]));
            graph.put(time[0], edges);
        }

        Map<Integer, Integer> delay = new LinkedHashMap<>();
        Deque<Integer> q = new ArrayDeque<>();

        q.add(K);
        delay.put(K, 0);

        while (!q.isEmpty()) {
            int curr = q.removeFirst();
            List<Edge> neighbors = graph.getOrDefault(curr, new ArrayList<>());
            for (Edge neighbor : neighbors) {
                int nextDelay = delay.get(curr) + neighbor.weight;
                if (delay.getOrDefault(neighbor.to, Integer.MAX_VALUE) > nextDelay) {
                    delay.put(neighbor.to, nextDelay);
                    q.addLast(neighbor.to);
                }
            }
        }

        if (delay.size() < N) {
            return -1;
        } else {
            return delay.entrySet().stream().map(entry -> entry.getValue()).max(Comparator.comparingInt(val -> val))
                    .get();
        }
    }

    class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
// @lc code=end
