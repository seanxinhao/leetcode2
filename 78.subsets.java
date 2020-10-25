import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        helper(results, new ArrayList<>(), nums, 0);
        return results;
    }

    private static void helper(List<List<Integer>> results, List<Integer> set, int[] nums, int pos) {
        results.add(new ArrayList<>(set));
        if (pos == nums.length) {
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            set.add(nums[i]);
            helper(results, set, nums, i + 1);
            set.remove(set.size() - 1);
        }
    }
}
// @lc code=end
