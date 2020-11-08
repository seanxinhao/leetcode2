import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        if (m == 0 || n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < m; i++) {
            int size = triangle.get(i).size();
            for (int j = size - 1; j >= 0; j--) {
                dp[j] = Math.min(dp[j], (j - 1 >= 0 ? dp[j - 1] : Integer.MAX_VALUE)) + triangle.get(i).get(j);
            }
        }

        return IntStream.of(dp).min().getAsInt();
    }
}
// @lc code=end
