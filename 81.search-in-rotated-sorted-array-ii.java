/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else {
                if (nums[left] < nums[mid]) {
                    if (nums[mid] < target) {
                        left = mid + 1;
                    } else {
                        if (nums[left] <= target) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    }
                } else if (nums[left] > nums[mid]) {
                    if (nums[mid] > target) {
                        right = mid - 1;
                    } else {
                        if (nums[left] <= target) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    }
                } else {
                    // nums[left] == nums[mid] == nums[right]
                    // we won't know where the target is located.
                    // so move left to break the tie.
                    left++;
                }
            }
        }

        if (left >= 0 && left < n && nums[left] == target) {
            return true;
        }
        return false;
    }
}
// @lc code=end
