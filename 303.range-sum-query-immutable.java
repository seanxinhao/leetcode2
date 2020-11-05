/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */

// @lc code=start
class NumArray {
    private int[] cumulateSum;

    public NumArray(int[] nums) {
        cumulateSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            cumulateSum[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return cumulateSum[j];
        } else {
            return cumulateSum[j] - cumulateSum[i - 1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */
// @lc code=end
