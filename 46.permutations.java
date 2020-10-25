import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        helper(results, new LinkedHashSet<>(), nums, 0);
        return results;
    }

    private static void helper(List<List<Integer>> results, Set<Integer> tuple, int[] nums, int pos) {
        if (pos == nums.length) {
            results.add(new ArrayList<>(tuple));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!tuple.contains(nums[i])) {
                tuple.add(nums[i]);
                helper(results, tuple, nums, pos + 1);
                tuple.remove(nums[i]);
            }
        }
    }

}
// @lc code=end
