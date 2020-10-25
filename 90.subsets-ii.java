import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        helper(results, new ArrayList<>(), nums, 0);
        return results;
    }

    private static void helper(List<List<Integer>> results, List<Integer> set, int[] nums, int pos) {
        results.add(new ArrayList<>(set));
        if (pos == nums.length) {
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            set.add(nums[i]);
            helper(results, set, nums, i + 1);
            set.remove(set.size() - 1);
        }
    }
}
// @lc code=end
