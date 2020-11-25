/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];

        int left = min;
        int right = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int place = 0;
            int bound = Integer.MIN_VALUE;
            for (int[] row : matrix) {
                int l = 0;
                int r = row.length;
                while (l < r) {
                    int m = l + (r - l) / 2;
                    if (row[m] <= mid) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                if (l - 1 < row.length && l - 1 >= 0) {
                    bound = Math.max(bound, row[l - 1]);
                }
                place += l;
            }

            if (place == k) {
                return bound;
            } else if (place < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
// @lc code=end
