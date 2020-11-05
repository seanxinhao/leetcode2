import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        return canParition(nums, 0, 0, visited);
    }

    private boolean canParition(int[] nums, int sum1, int sum2, Set<Integer> visited) {
        if (visited.size() == nums.length && sum1 == sum2) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (visited.contains(i)) {
                continue;
            }
            visited.add(i);
            boolean sub1 = canParition(nums, sum1 + num, sum2, visited);
            boolean sub2 = canParition(nums, sum1, sum2 + num, visited);
            visited.remove(i);
            if (sub1 || sub2) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
