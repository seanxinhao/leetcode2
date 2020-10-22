import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int diff = target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] < diff) {
                        left++;
                    } else if (nums[left] + nums[right] > diff) {
                        right--;
                    } else {
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[left]);
                        res.add(nums[right]);
                        results.add(res);

                        left++;
                        right--;
                        while (left < nums.length && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (right >= 0 && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return results;
    }
}
// @lc code=end
