/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // when j is root.
            // 0 -> 1
            // 1 -> 1
            // 2 -> 1,0 + 0,1 = 2
            // 3 -> 2,0 + 1,1 + 0,2 = 5
            int count = 0;
            for (int j = 1; j <= i; j++) {
                count += dp[j - 1] * dp[i - j];
            }
            dp[i] = count;
        }
        return dp[n];
    }
}
// @lc code=end
