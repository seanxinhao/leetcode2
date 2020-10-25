import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        Arrays.fill(used, false);
        helper(results, new ArrayList<>(), nums, used, 0);
        return results;
    }

    private static void helper(List<List<Integer>> results, List<Integer> tuple, int[] nums, boolean[] used,
            int depth) {
        if (depth == nums.length) {
            results.add(new ArrayList<>(tuple));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) || used[i] == true) {
                continue;
            }
            tuple.add(nums[i]);
            used[i] = true;
            helper(results, tuple, nums, used, depth + 1);
            tuple.remove(tuple.size() - 1);
            used[i] = false;
        }
    }
}
// @lc code=end
