import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }

        int max = map.keySet().stream().max(Comparator.naturalOrder()).get();
        int[] dp = new int[max + 1];

        for (int key : map.keySet()) {
            dp[key] = map.getOrDefault(key, 0);
        }

        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(map.getOrDefault(i, 0) + dp[i - 2], dp[i - 1]);
        }

        return dp[max];
    }
}
// @lc code=end
