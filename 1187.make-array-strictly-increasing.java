import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=1187 lang=java
 *
 * [1187] Make Array Strictly Increasing
 */

// @lc code=start
class Solution {
    public int makeArrayIncreasing(int[] a, int[] b) {
        b = IntStream.of(b).distinct().sorted().toArray();
        int inf = (int) 1e9 + 1;
        int l1 = a.length;
        int l2 = b.length;

        int[][] keep = new int[l1][l2];
        int[][] replace = new int[l1][l2];

        for (int i = 0; i < l1; i++) {
            Arrays.fill(keep[i], inf);
            Arrays.fill(replace[i], inf);
        }

        for (int j = 0; j < l2; j++) {
            keep[0][j] = 0;
            replace[0][j] = 1;
        }

        for (int i = 1; i < l1; i++) {
            int mink = IntStream.of(keep[i - 1]).min().getAsInt();
            int mins = inf; // min of replace[i - 1][k]; k < j
            for (int j = 0; j < l2; j++) {
                if (a[i] > a[i - 1]) {
                    // Keep to increase.
                    keep[i][j] = Math.min(keep[i][j], keep[i - 1][j]);
                }
                if (b[j] > a[i - 1]) {
                    // Replace to increase.
                    replace[i][j] = Math.min(replace[i][j], mink + 1);
                }
                if (a[i] > b[j]) {
                    // Increasing if last step replace.
                    keep[i][j] = Math.min(keep[i][j], replace[i - 1][j]);
                }
                // Increasing if last step and this step replace.
                // Following cause TLE.
                // for (int k = j + 1; k < l2; k++) {
                // replace[i][k] = Math.min(replace[i][k], replace[i - 1][j] + 1);
                // }
                replace[i][j] = Math.min(replace[i][j], mins + 1);
                mins = Math.min(mins, replace[i - 1][j]);
            }
        }

        int res = Math.min(IntStream.of(keep[l1 - 1]).min().getAsInt(), IntStream.of(replace[l1 - 1]).min().getAsInt());
        return res >= inf ? -1 : res;
    }
}
// @lc code=end
