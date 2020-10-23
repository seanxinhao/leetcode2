/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int top = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[top]) {
                top = i;
            }
        }
        int waterMount = 0;
        int left = 0;
        int right = left + 1;
        while (left < top) {
            right = left + 1;
            while (right <= top && height[right] < height[left]) {
                right++;
            }
            if (right <= top && height[right] >= height[left]) {
                int waterHeight = Math.min(height[left], height[right]);
                for (int i = left + 1; i < right; i++) {
                    int diff = waterHeight - height[i];
                    waterMount += diff;
                }
            }
            left = right;
        }
        right = height.length - 1;
        left = right - 1;
        while (right > top) {
            left = right - 1;
            while (left >= top && height[left] < height[right]) {
                left--;
            }
            if (left >= top && height[left] >= height[right]) {
                int waterHeight = Math.min(height[left], height[right]);
                for (int i = left + 1; i < right; i++) {
                    int diff = waterHeight - height[i];
                    waterMount += diff;
                }
            }
            right = left;
        }
        return waterMount;
    }
}
// @lc code=end
