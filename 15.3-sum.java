import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);

                    int j = left + 1;
                    while (j < nums.length && nums[j] == nums[left]) {
                        j++;
                    }

                    int k = right - 1;
                    while (k >= i && nums[k] == nums[right]) {
                        k--;
                    }

                    left = j;
                    right = k;
                }
            }
        }
        return results;
    }
}
// @lc code=end
