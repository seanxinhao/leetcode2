import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        helper(results, new ArrayList<>(), 1, 0, k, n);
        return results;
    }

    public static void helper(List<List<Integer>> results, List<Integer> selected, int pos, int iteration, int k,
            int target) {
        if (iteration > k) {
            return;
        }
        if (iteration == k && target == 0) {
            List<Integer> answer = new ArrayList<>(selected);
            results.add(answer);
            return;
        }
        for (int i = pos; i < 10; i++) {
            if (i > target) {
                continue;
            }
            selected.add(i);
            helper(results, selected, i + 1, iteration + 1, k, target - i);
            selected.remove(selected.size() - 1);
        }
    }
}
// @lc code=end
