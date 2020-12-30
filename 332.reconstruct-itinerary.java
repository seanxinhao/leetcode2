/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        int n = tickets.size();
        Map<String, List<String>> map = new LinkedHashMap<>();
        Map<String, Set<Integer>> visited = new LinkedHashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            visited.put(from, new HashSet<>());
            List<String> value = map.getOrDefault(from, new ArrayList<>());
            value.add(to);
            map.put(from, value);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        return dfs(map, visited, n, "JFK");
    }

    private List<String> dfs(Map<String, List<String>> map, Map<String, Set<Integer>> visited, int n, String from) {
        List<String> ans = new ArrayList<>();
        ans.add(from);

        if (n == 0 || map.get(from) == null) {
            return ans;
        }

        List<String> next = map.get(from);
        Set<Integer> v = visited.get(from);
        for (int i = 0; i < next.size(); i++) {
            if (v.contains(i)) {
                continue;
            }
            v.add(i);
            String to = next.get(i);
            List<String> sub = dfs(map, visited, n - 1, to);
            if (sub.size() == n) {
                ans.addAll(sub);
                return ans;
            }
            v.remove(i);
        }

        return ans;
    }
}
// @lc code=end
