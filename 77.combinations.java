import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        helper(results, new ArrayList<>(), 1, n, 1, k);
        return results;
    }

    private static void helper(List<List<Integer>> results, List<Integer> previous, int start, int n, int pos, int k) {
        if (pos > k) {
            if (!previous.isEmpty()) {
                results.add(new ArrayList<>(previous));
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            previous.add(i);
            helper(results, previous, i + 1, n, pos + 1, k);
            previous.remove(previous.size() - 1);
        }
    }
}
// @lc code=end
