import java.util.Arrays;

/*
 * @lc app=leetcode id=1105 lang=java
 *
 * [1105] Filling Bookcase Shelves
 */

// @lc code=start
class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = books[0][1];

        for (int i = 1; i < n; i++) {
            int height = 0;
            int width = 0;
            for (int j = i; j >= 0; j--) {
                if (width + books[j][0] <= shelf_width) {
                    height = Math.max(height, books[j][1]);
                    width += books[j][0];
                    if (j != 0) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + height);
                    } else {
                        dp[i] = Math.min(dp[i], height);
                    }
                } else {
                    break;
                }
            }
        }

        return dp[n - 1];
    }
}
// @lc code=end
