/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];

        if (n == 0) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }

        int left = 0;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left < n && nums[left] == target) {
            ans[0] = left;
        } else {
            ans[0] = -1;
        }

        left = 0;
        right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left - 1 >= 0 && nums[left - 1] == target) {
            ans[1] = left - 1;
        } else {
            ans[1] = -1;
        }

        return ans;
    }
}
// @lc code=end
