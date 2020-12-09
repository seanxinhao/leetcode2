import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=163 lang=java
 *
 * [163] Missing Ranges
 */

// @lc code=start
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<int[]> ans = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            ans.add(new int[] { lower, upper });
        } else {
            int first = nums[0];
            if (lower < first) {
                ans.add(new int[] { lower, first - 1 });
            }
            for (int i = 0; i < n - 1; i++) {
                int left = nums[i];
                int right = nums[i + 1];
                if (left > upper) {
                    break;
                }
                if (left < lower || left + 1 == right) {
                    continue;
                }
                int l = Math.max(left, lower);
                int r = Math.min(right, upper);
                l = l == left ? l + 1 : l;
                r = r == right ? r - 1 : r;
                ans.add(new int[] { l, r });
            }
            int last = nums[n - 1];
            if (last < upper) {
                ans.add(new int[] { last + 1, upper });
            }
        }
        return ans.stream().map(range -> {
            if (range[0] == range[1]) {
                return Integer.toString(range[0]);
            } else {
                return range[0] + "->" + range[1];
            }
        }).collect(Collectors.toList());
    }
}
// @lc code=end
