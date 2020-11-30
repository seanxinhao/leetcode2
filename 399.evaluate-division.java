import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */

// @lc code=start
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            double value = values[i];
            Map<String, Double> submap = graph.getOrDefault(a, new LinkedHashMap<>());
            submap.put(b, value);
            submap.put(a, 1.0);
            graph.put(a, submap);

            submap = graph.getOrDefault(b, new LinkedHashMap<>());
            submap.put(a, 1.0 / value);
            submap.put(b, 1.0);
            graph.put(b, submap);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String s = query.get(0);
            String d = query.get(1);
            Set<String> visited = new HashSet<>();
            res[i] = dfs(graph, visited, s, d);
        }

        return res;
    }

    private double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String s, String d) {
        if (!graph.containsKey(s) || visited.contains(s)) {
            return -1;
        }
        visited.add(s);
        Map<String, Double> submap = graph.get(s);
        for (Map.Entry<String, Double> entry : submap.entrySet()) {
            if (entry.getKey().equals(d)) {
                return entry.getValue();
            }
            double subres = dfs(graph, visited, entry.getKey(), d);
            if (subres != -1) {
                return entry.getValue() * subres;
            }
        }

        return -1;
    }
}
// @lc code=end
