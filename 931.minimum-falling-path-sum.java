import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[] current = new int[n];
        Arrays.fill(current, Integer.MAX_VALUE);

        int min = Integer.MAX_VALUE;
        int pick = 0;
        while (pick < n) {
            int[] prev = new int[n];
            Arrays.fill(prev, Integer.MAX_VALUE);
            prev[pick] = A[0][pick];
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (prev[j] != Integer.MAX_VALUE) {
                        if (j - 1 >= 0) {
                            current[j - 1] = Math.min(current[j - 1], prev[j] + A[i][j - 1]);
                        }
                        current[j] = Math.min(current[j], prev[j] + A[i][j]);
                        if (j + 1 < n) {
                            current[j + 1] = Math.min(current[j + 1], prev[j] + A[i][j + 1]);
                        }
                    }
                }
                int[] temp = prev;
                prev = current;
                current = temp;
                Arrays.fill(current, Integer.MAX_VALUE);
            }
            int localMin = IntStream.of(prev).min().getAsInt();
            if (localMin < min) {
                min = localMin;
            }
            pick++;
        }

        return min;
    }
}
// @lc code=end
