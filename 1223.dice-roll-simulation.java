import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=1223 lang=java
 *
 * [1223] Dice Roll Simulation
 */

// @lc code=start
class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int mod = (int) 1e9 + 7;
        int m = 6; // length of the numbers;
        int k = IntStream.of(rollMax).max().getAsInt();
        // n => seq number of rolls.
        // m => last number.
        // k => k th occurance of last number m.
        int[][][] dp = new int[n + 1][m + 1][k + 1];
        // dp[i][j][k] => At i th rolls, the last number is j
        // and it has been k th j in a row.

        for (int j = 1; j <= m; j++) {
            dp[1][j][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // when k = 1;
                int sum = 0;
                for (int l = 1; l <= k; l++) {
                    for (int jc = 1; jc <= m; jc++) {
                        if (jc != j) {
                            sum += dp[i - 1][jc][l];
                            sum %= mod;
                        }
                    }
                }
                dp[i][j][1] = sum;
                // when k != 1
                for (int l = 2; l <= k; l++) {
                    if (l > rollMax[j - 1]) {
                        break;
                    }
                    dp[i][j][l] = dp[i - 1][j][l - 1];
                }
            }
        }

        int sum = 0;
        for (int j = 1; j <= m; j++) {
            for (int l = 1; l <= k; l++) {
                sum += dp[n][j][l];
                sum %= mod;
            }
        }
        return sum;
    }
}
// @lc code=end
