import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=698 lang=java
 *
 * [698] Partition to K Equal Sum Subsets
 */

// @lc code=start
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = IntStream.of(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        int target = sum / k;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > target) {
                return false;
            }
        }

        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        return helper(nums, used, target, 0, k);
    }

    private static boolean helper(int[] nums, boolean[] used, int target, int current, int k) {
        if (k == 0) {
            return current == 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            if (nums[i] + current < target) {
                // Add to subset.
                if (helper(nums, used, target, nums[i] + current, k)) {
                    return true;
                }
            } else if (nums[i] + current == target) {
                // End subset.
                if (helper(nums, used, target, 0, k - 1)) {
                    return true;
                }
            } else {
                // This and the rest of numbers don't fit.
                used[i] = false;
                return false;
            }
            used[i] = false;
        }

        return false;
    }
}
// @lc code=end
