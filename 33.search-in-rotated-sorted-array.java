/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[left] <= nums[mid]) {
                    if (nums[mid] < target) {
                        left = mid + 1;
                    } else {
                        if (nums[left] <= target) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    }
                } else {
                    if (nums[mid] > target) {
                        right = mid - 1;
                    } else {
                        if (nums[left] <= target) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    }
                }
            }
        }

        if (left >= 0 && left < n && nums[left] == target) {
            return left;
        }
        return -1;
    }
}
// @lc code=end
