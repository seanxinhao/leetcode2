/*
 * @lc app=leetcode id=935 lang=java
 *
 * [935] Knight Dialer
 */

// @lc code=start
class Solution {
    public int knightDialer(int n) {
        int r = 4;
        int c = 3;
        int mod = (int) 1e9 + 7;

        int[][][] dp = new int[n + 1][r][c];
        int[] pos = { -2, -1, +1, +2 };

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == r - 1 && j == 0 || i == r - 1 && j == c - 1) {
                    dp[1][i][j] = 0;
                } else {
                    dp[1][i][j] = 1;
                }
            }
        }

        for (int nc = 2; nc <= n; nc++) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i == r - 1 && j == 0 || i == r - 1 && j == c - 1) {
                        dp[nc][i][j] = 0;
                    } else {
                        for (int x : pos) {
                            for (int y : pos) {
                                if (Math.abs(x) != Math.abs(y) && i + y >= 0 && i + y < r && j + x >= 0 && j + x < c) {
                                    dp[nc][i][j] += dp[nc - 1][i + y][j + x];
                                    dp[nc][i][j] %= mod;
                                }
                            }
                        }
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum += dp[n][i][j];
                sum %= mod;
            }
        }

        return sum;
    }
}
// @lc code=end
