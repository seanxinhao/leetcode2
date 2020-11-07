import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        int[] dp = new int[n];

        int buy = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] > buy) {
                dp[i] = prices[i] - buy;
            } else {
                buy = prices[i];
            }
        }

        return IntStream.of(dp).max().getAsInt();
    }
}
// @lc code=end
