/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < (mid - 1 >= 0 ? nums[mid - 1] : Integer.MAX_VALUE)
                    && nums[mid] < (mid + 1 < n ? nums[mid + 1] : Integer.MAX_VALUE)) {
                return nums[mid];
            } else {
                if (nums[left] < nums[mid]) {
                    if (nums[mid] <= nums[right]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[left] > nums[mid]) {
                    right = mid;
                } else {
                    if (nums[mid] < nums[right]) {
                        return nums[mid];
                    } else if (nums[mid] > nums[right]) {
                        left = mid + 1;
                    } else {
                        if (left == mid && mid == right) {
                            return nums[mid];
                        } else {
                            left++;
                        }
                    }
                }
            }
        }

        return nums[left];
    }
}
// @lc code=end
