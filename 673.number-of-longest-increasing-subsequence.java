import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cdp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            if (max == 1) {
                cdp[i] = 1;
            } else {
                int count = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i] && dp[j] == max - 1) {
                        count += cdp[j];
                    }
                }
                cdp[i] = count;
            }
        }
        int max = IntStream.of(dp).max().getAsInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                count += cdp[i];
            }
        }
        return count;
    }
}
// @lc code=end
