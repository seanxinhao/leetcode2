import java.util.Arrays;

/*
 * @lc app=leetcode id=688 lang=java
 *
 * [688] Knight Probability in Chessboard
 */

// @lc code=start
class Solution {
    int N;
    double[][][] mem;

    public double knightProbability(int N, int K, int r, int c) {
        this.N = N;
        mem = new double[K][N][N];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(mem[i][j], -1);
            }
        }
        return 1 - helper(K, r, c);
    }

    private double helper(int k, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (mem[k - 1][r][c] != -1) {
            return mem[k - 1][r][c];
        }
        double ans = (helper(k - 1, r - 1, c - 2) + +helper(k - 1, r - 1, c + 2) + helper(k - 1, r - 2, c - 1)
                + helper(k - 1, r - 2, c + 1) + helper(k - 1, r + 1, c - 2) + helper(k - 1, r + 1, c + 2)
                + helper(k - 1, r + 2, c - 1) + helper(k - 1, r + 2, c + 1)) / 8;
        mem[k - 1][r][c] = ans;
        return ans;
    }
}
// @lc code=end
