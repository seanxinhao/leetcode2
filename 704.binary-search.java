/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left >= 0 && left < n && nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}
// @lc code=end
