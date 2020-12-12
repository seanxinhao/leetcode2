/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int write = 1;
        int prev = nums[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            if (curr == prev) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[write] = curr;
                write++;
            }
            prev = curr;
        }

        return write;
    }
}
// @lc code=end
