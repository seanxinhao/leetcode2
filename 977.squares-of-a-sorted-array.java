/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int i = 0;
        int j = 0;
        while (i < A.length && A[i] < 0) {
            i++;
        }

        int left = i - 1;
        int right = i;

        while (left >= 0 && right < A.length) {
            int leftSqr = A[left] * A[left];
            int rightSqr = A[right] * A[right];
            if (leftSqr < rightSqr) {
                result[j] = leftSqr;
                left--;
            } else {
                result[j] = rightSqr;
                right++;
            }
            j++;
        }

        while (left >= 0) {
            int leftSqr = A[left] * A[left];
            result[j] = leftSqr;
            left--;
            j++;
        }

        while (right < A.length) {
            int rightSqr = A[right] * A[right];
            result[j] = rightSqr;
            right++;
            j++;
        }
        return result;
    }
}
// @lc code=end
