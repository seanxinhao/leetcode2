import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = IntStream.of(nums).sum();
        if (sum == 0 || sum % 2 != 0 || nums.length < 2) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int num : nums) {
            for (int i = target; i >= 1; i--) {
                if (i - num >= 0 && dp[i - num] > 0) {
                    dp[i]++;
                }
            }
        }

        return dp[target] > 0;
    }
}
// @lc code=end
