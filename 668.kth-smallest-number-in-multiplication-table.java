/*
 * @lc app=leetcode id=668 lang=java
 *
 * [668] Kth Smallest Number in Multiplication Table
 */

// @lc code=start
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int min = 1;
        int max = m * n;

        int left = min;
        int right = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int place = 0;
            int bound = Integer.MIN_VALUE;
            for (int i = 1; i <= m; i++) {
                int l = 1;
                int r = n + 1;
                while (l < r) {
                    int mi = l + (r - l) / 2;
                    if (mi * i <= mid) {
                        l = mi + 1;
                    } else {
                        r = mi;
                    }
                }
                if (l - 1 <= n && l >= 1) {
                    bound = Math.max(bound, (l - 1) * i);
                }
                place += (l - 1);
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
