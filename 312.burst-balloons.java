import java.util.Arrays;

/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] nums2 = new int[n + 2];
        nums2[0] = 1;
        for (int i = 0; i < n; i++) {
            nums2[i + 1] = nums[i];
        }
        nums2[n + 1] = 1;
        n = nums2.length;

        int[][] dp = new int[n][n];
        // dp[i][j] means max coins of sub-array [i, j] of nums2.
        // dp[i][j] = 0 when j - i < 2
        // dp[i][j] = max{nums2[i] * nums2[k] * nums2[j] + dp[i, k] + dp[k, j]}
        // when i < k < j

        // Traverse from small sub-arrays to large.
        for (int length = 2; length < n; length++) {
            for (int start = 0; start < n - length; start++) {
                int i = start;
                int j = start + length;
                int max = 0;
                for (int k = i + 1; k < j; k++) {
                    max = Math.max(max, nums2[i] * nums2[k] * nums2[j] + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = max;
            }
        }

        return dp[0][n - 1];
    }
}
// @lc code=end
