import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int total = IntStream.of(nums).sum();
        int[] prev = new int[2 * total + 1];
        int[] next = new int[2 * total + 1];
        Arrays.fill(prev, 0);
        Arrays.fill(next, 0);
        prev[0 + total] = 1;
        for (int num : nums) {
            Arrays.fill(next, 0);
            for (int i = -total; i <= total; i++) {
                if (prev[i + total] != 0) {
                    next[i + num + total] += prev[i + total];
                    next[i - num + total] += prev[i + total];
                }
            }
            int[] temp = prev;
            prev = next;
            next = temp;
        }
        if (S + total >= 0 && S + total < prev.length) {
            return prev[S + total];
        } else {
            return 0;
        }
    }
}
// @lc code=end
