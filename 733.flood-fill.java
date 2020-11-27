/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            visit(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    private void visit(int[][] image, int i, int j, int startColor, int newColor) {
        int m = image.length;
        int n = image[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (image[i][j] == startColor) {
            image[i][j] = newColor;
            visit(image, i - 1, j, startColor, newColor);
            visit(image, i + 1, j, startColor, newColor);
            visit(image, i, j - 1, startColor, newColor);
            visit(image, i, j + 1, startColor, newColor);
        }
    }
}
// @lc code=end
