import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=1202 lang=java
 *
 * [1202] Smallest String With Swaps
 */

// @lc code=start
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();

        int[] ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }

        for (List<Integer> pair : pairs) {
            union(ids, pair.get(0), pair.get(1));
        }

        Map<Integer, List<Character>> chars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            int id = find(ids, i);
            List<Character> v = chars.getOrDefault(id, new ArrayList<>());
            v.add(s.charAt(i));
            chars.put(id, v);
        }

        for (Map.Entry<Integer, List<Character>> entry : chars.entrySet()) {
            entry.getValue().sort(Comparator.<Character, Character>comparing(c -> c).reversed());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            List<Character> v = chars.get(find(ids, i));
            sb.append(v.get(v.size() - 1));
            v.remove(v.size() - 1);
        }

        return sb.toString();
    }

    private int find(int[] ids, int v) {
        if (v == ids[v]) {
            return v;
        }
        return ids[v] = find(ids, ids[v]);
    }

    private void union(int[] ids, int v1, int v2) {
        int p1 = find(ids, v1);
        int p2 = find(ids, v2);
        if (p1 > p2) {
            ids[p1] = p2;
        } else {
            ids[p2] = p1;
        }
    }
}
// @lc code=end
