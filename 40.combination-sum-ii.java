import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        helper(results, new ArrayList<>(), candidates, 0, target);
        return results;
    }

    public static void helper(List<List<Integer>> results, List<Integer> selectedList, int[] candidates, int startPos,
            int target) {
        if (target == 0) {
            results.add(selectedList);
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = startPos; i < candidates.length; i++) {
            int selected = candidates[i];
            if (i > startPos && selected == candidates[i - 1]) {
                continue;
            }
            List<Integer> branch = new ArrayList<>(selectedList);
            branch.add(selected);
            helper(results, branch, candidates, i + 1, target - selected);
        }
    }
}
// @lc code=end
