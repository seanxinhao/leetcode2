import java.util.Set;

/*
 * @lc app=leetcode id=433 lang=java
 *
 * [433] Minimum Genetic Mutation
 */

// @lc code=start
class Solution {
    Map<String, Set<String>> graph = new HashMap<>();

    public int minMutation(String start, String end, String[] bank) {
        int n = bank.length;
        for (int i = 0; i < n; i++) {
            if (distance(start, bank[i]) == 1) {
                Set<String> adjs = graph.getOrDefault(start, new LinkedHashSet<>());
                adjs.add(bank[i]);
                graph.put(start, adjs);

                adjs = graph.getOrDefault(bank[i], new LinkedHashSet<>());
                adjs.add(start);
                graph.put(bank[i], adjs);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (distance(bank[i], bank[j]) == 1) {
                    Set<String> adjs = graph.getOrDefault(bank[i], new LinkedHashSet<>());
                    adjs.add(bank[j]);
                    graph.put(bank[i], adjs);
                    adjs = graph.getOrDefault(bank[j], new LinkedHashSet<>());
                    adjs.add(bank[i]);
                    graph.put(bank[j], adjs);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        return dfs(visited, start, end);
    }

    private int dfs(Set<String> visited, String start, String end) {
        if (start.equals(end)) {
            return 0;
        }
        visited.add(start);
        Set<String> adjs = graph.get(start);
        int minDist = Integer.MAX_VALUE;
        if (adjs != null) {
            for (String adj : adjs) {
                if (!visited.contains(adj)) {
                    int dist = dfs(visited, adj, end);
                    if (dist != -1) {
                        minDist = Math.min(minDist, dist + 1);
                    }
                }
            }
        }
        visited.remove(start);
        if (minDist == Integer.MAX_VALUE) {
            return -1;
        }
        return minDist;
    }

    private int distance(String a, String b) {
        int l = a.length();
        int count = 0;
        for (int i = 0; i < l; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end
