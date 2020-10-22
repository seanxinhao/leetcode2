import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(results, new ArrayList<>(), candidates, target);
        return results;
    }

    private static void combinationSumHelper(List<List<Integer>> results, List<Integer> selected, int[] candidates,
            int target) {
        if (target == 0) {
            results.add(selected);
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            int next = candidates[i];
            if (selected.isEmpty() || (selected.size() > 0 && next >= selected.get(selected.size() - 1))) {
                List<Integer> branch = new ArrayList<>(selected);
                branch.add(next);
                combinationSumHelper(results, branch, candidates, target - next);
            }
        }
    }
}
// @lc code=end
