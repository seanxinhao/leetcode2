/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid - 1 < 0 || nums[mid] > nums[mid - 1]) && (mid + 1 >= n || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid + 1 < n && nums[mid] <= nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
// @lc code=end
