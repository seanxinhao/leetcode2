/*
 * @lc app=leetcode id=941 lang=java
 *
 * [941] Valid Mountain Array
 */

// @lc code=start
class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        int i = 0;
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        int j = n - 1;
        while (j - 1 >= 0 && arr[j - 1] > arr[j]) {
            j--;
        }
        return i == j && i != 0 && j != n - 1;
    }
}
// @lc code=end
