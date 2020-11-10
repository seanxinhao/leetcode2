/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[] cd = new int[n];
        int[] hold = new int[n];
        int[] sold = new int[n];

        cd[0] = 0;
        hold[0] = -1 * prices[0];
        sold[0] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            cd[i] = Math.max(cd[i - 1], sold[i - 1]);
            hold[i] = Math.max(hold[i - 1], cd[i - 1] - prices[i]);
            sold[i] = hold[i - 1] + prices[i];
        }

        return Math.max(cd[n - 1], Math.max(hold[n - 1], sold[n - 1]));
    }

    // TLE recursive solution.
    private static int maxProfitHelper(int[] prices, int pos, int lastState, int lastProfit) {
        if (pos == prices.length) {
            return lastProfit;
        }
        int maxProfit = 0;
        // Last CD
        if (lastState == 0) {
            maxProfit = Math.max(maxProfit, maxProfitHelper(prices, pos + 1, 0, lastProfit)); // continue CD.
            maxProfit = Math.max(maxProfit, maxProfitHelper(prices, pos + 1, 1, lastProfit - prices[pos])); // start
                                                                                                            // hold.
        } else if (lastState == 1) { // last hold
            maxProfit = Math.max(maxProfit, maxProfitHelper(prices, pos + 1, 1, lastProfit)); // continue hold.
            maxProfit = Math.max(maxProfit, maxProfitHelper(prices, pos + 1, 2, lastProfit + prices[pos])); // start
                                                                                                            // sold.
        } else if (lastState == 2) { // last sold
            maxProfit = maxProfitHelper(prices, pos + 1, 0, lastProfit); // start sold.
        }
        return maxProfit;
    }
}
// @lc code=end
