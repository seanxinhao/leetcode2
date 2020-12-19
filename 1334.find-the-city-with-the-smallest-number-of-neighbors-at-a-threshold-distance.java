/*
 * @lc app=leetcode id=1334 lang=java
 *
 * [1334] Find the City With the Smallest Number of Neighbors at a Threshold Distance
 */

// @lc code=start
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new Node(edge[1], edge[2]));
            graph[edge[1]].add(new Node(edge[0], edge[2]));
        }

        int min = Integer.MAX_VALUE;
        int minCity = 0;
        for (int i = 0; i < n; i++) {
            Deque<Integer> q = new ArrayDeque<>();
            Map<Integer, Integer> distance = new HashMap<>();
            q.addLast(i);
            distance.put(i, 0);
            while (!q.isEmpty()) {
                int curr = q.removeFirst();
                int currDist = distance.get(curr);
                List<Node> adjs = graph[curr];
                for (Node adj : adjs) {
                    int nextDist = currDist + adj.distance;
                    if (distance.getOrDefault(adj.city, Integer.MAX_VALUE) > nextDist
                            && nextDist <= distanceThreshold) {
                        distance.put(adj.city, nextDist);
                        q.addLast(adj.city);
                    }
                }
            }
            int cityNum = distance.keySet().size() - 1;
            if (cityNum <= min) {
                min = cityNum;
                minCity = i;
            }
        }
        return minCity;
    }

    class Node {
        int city;
        int distance;

        public Node(int city, int distance) {
            this.city = city;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d]", city, distance);
        }
    }
}
// @lc code=end
