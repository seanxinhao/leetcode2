/*
 * @lc app=leetcode id=801 lang=java
 *
 * [801] Minimum Swaps To Make Sequences Increasing
 */

// @lc code=start
class Solution {
    private int ans = Integer.MAX_VALUE;

    public int minSwap(int[] A, int[] B) {
        // DP solution.
        int n = A.length;
        int[] keep = new int[n];
        int[] swap = new int[n];

        keep[0] = 0;
        swap[0] = 1;

        for (int i = 1; i < n; i++) {
            int kk = 10000; // keep(i - 1) and keep(i)
            int ks = 10000; // keep(i - 1) and swap(i)
            int sk = 10000; // swap(i - 1) and keep(i)
            int ss = 10000; // swap(i - 1) and swap(i)

            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                // keep and keep or swap and swap when original order is good.
                kk = keep[i - 1];
                ss = swap[i - 1] + 1;
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                // keep and swap or swap and keep when one swap result would be good.
                sk = swap[i - 1];
                ks = keep[i - 1] + 1;
            }
            keep[i] = Math.min(kk, sk);
            swap[i] = Math.min(ss, ks);
        }
        return Math.min(keep[n - 1], swap[n - 1]);
    }

    // TLE recursive solution. (84/102)
    private void helper(int[] A, int[] B, int pos, int count) {
        if (count >= ans) {
            return;
        }
        if (pos == A.length) {
            ans = Math.min(ans, count);
            return;
        }
        if (A[pos - 1] < A[pos] && B[pos - 1] < B[pos]) {
            helper(A, B, pos + 1, count);
        }
        if (B[pos - 1] < A[pos] && A[pos - 1] < B[pos]) {
            swap(A, B, pos);
            helper(A, B, pos + 1, count + 1);
            swap(A, B, pos);
        }
    }

    private static void swap(int[] A, int[] B, int i) {
        int temp = A[i];
        A[i] = B[i];
        B[i] = temp;
    }
}
// @lc code=end
