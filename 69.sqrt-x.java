/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > 46340) {
                right = mid - 1;
            } else {
                if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                    return mid;
                } else if (mid * mid < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return left > 46340 ? 46340 : left;
    }
}
// @lc code=end
