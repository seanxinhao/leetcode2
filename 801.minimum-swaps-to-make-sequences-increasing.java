/*
 * @lc app=leetcode id=801 lang=java
 *
 * [801] Minimum Swaps To Make Sequences Increasing
 */

// @lc code=start
class Solution {
    private int ans = Integer.MAX_VALUE;

    public int minSwap(int[] A, int[] B) {
        helper(A, B, 1, 0);
        return ans;
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
