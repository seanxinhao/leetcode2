/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = getArea(height, left, right);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    private static int getArea(int[] height, int i, int j) {
        return Math.min(height[i], height[j]) * Math.abs(i - j);
    }
}
// @lc code=end
