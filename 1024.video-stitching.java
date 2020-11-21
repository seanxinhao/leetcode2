import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=1024 lang=java
 *
 * [1024] Video Stitching
 */

// @lc code=start
class Solution {
    int[][] clips;
    int[][] dp;
    int T;

    public int videoStitching(int[][] clips, int T) {
        this.clips = clips;
        this.T = T;
        dp = new int[T + 1][T + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = helper(0, T, new HashSet<>());
        return ans >= 1000 ? -1 : ans;
    }

    // video stitching of sub range from i to j.
    private int helper(int i, int j, Set<Integer> visited) {
        if (i > j || i < 0 || j > T) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = 1000;
        for (int c = 0; c < clips.length; c++) {
            if (visited.contains(c)) {
                continue;
            }
            int[] clip = clips[c];
            if (j < clip[0] || i > clip[1]) {
                continue;
            } else if (i >= clip[0] && j <= clip[1]) {
                min = 1;
                break;
            } else if (i >= clip[0]) {
                visited.add(c);
                min = Math.min(min, helper(clip[1], j, visited) + 1);
                visited.remove(c);
            } else if (j <= clip[1]) {
                visited.add(c);
                min = Math.min(min, helper(i, clip[0], visited) + 1);
                visited.remove(c);
            } else {
                visited.add(c);
                int left = helper(i, clip[0], visited);
                int right = helper(clip[1], j, visited);
                min = Math.min(min, left + 1 + right);
                visited.remove(c);
            }
        }
        dp[i][j] = min;
        return min;
    }
}
// @lc code=end
