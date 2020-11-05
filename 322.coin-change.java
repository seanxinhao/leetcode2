import java.util.Arrays;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] k = new int[amount + 1];
        Arrays.fill(k, amount + 1);
        k[0] = 0;
        for (int i = 0; i < k.length; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    k[i] = Math.min(k[i], k[i - coin] + 1);
                }
            }
        }
        if (k[amount] == amount + 1) {
            return -1;
        } else {
            return k[amount];
        }
    }
}
// @lc code=end
