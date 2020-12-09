import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=815 lang=java
 *
 * [815] Bus Routes
 */

// @lc code=start
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        int n = routes.length;
        Map<Integer, Set<Integer>> stopToBus = new HashMap<>();
        for (int bus = 0; bus < n; bus++) {
            int[] route = routes[bus];
            for (int stop : route) {
                Set<Integer> set = stopToBus.getOrDefault(stop, new HashSet<>());
                set.add(bus);
                stopToBus.put(stop, set);
            }
        }
        boolean[] busTaken = new boolean[n];
        int buses = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(S);
        while (!q.isEmpty()) {
            int s = q.size();
            buses++;
            for (int i = 0; i < s; i++) {
                int curr = q.removeFirst();
                for (int bus : stopToBus.get(curr)) {
                    if (busTaken[bus]) {
                        continue;
                    }
                    busTaken[bus] = true;
                    for (int stop : routes[bus]) {
                        if (stop == T) {
                            return buses;
                        }
                        q.addLast(stop);
                    }
                }
            }
        }

        return -1;
    }
}
// @lc code=end
