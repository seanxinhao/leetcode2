import java.util.Arrays;

/*
 * @lc app=leetcode id=719 lang=java
 *
 * [719] Find K-th Smallest Pair Distance
 */

// @lc code=start
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int left = 0;
        int right = nums[n - 1] - nums[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int place = 0;
            int edge = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int diff = nums[j] - nums[i];
                    if (diff >= mid) {
                        break;
                    } else {
                        place++;
                        edge = Math.max(edge, diff);
                    }
                }
            }

            if (place == k) {
                return edge;
            } else if (place < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
// @lc code=end
