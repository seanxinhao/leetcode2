/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            // make sure n1 <= n2
            return findMedianSortedArrays(nums2, nums1);
        }

        int target = (n1 + n2 + 1) / 2; // The first one of second half.
        int left = 0;
        int right = n1;
        while (left < right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = target - mid1;
            if (nums1[mid1] < nums2[mid2 - 1]) {
                left = mid1 + 1;
            } else {
                right = mid1;
            }
        }

        int mid1 = left;
        int mid2 = target - left;

        int res1 = Math.max(mid1 >= 1 ? nums1[mid1 - 1] : Integer.MIN_VALUE,
                mid2 >= 1 ? nums2[mid2 - 1] : Integer.MIN_VALUE);

        if ((n1 + n2) % 2 == 1) {
            return res1;
        }

        int res2 = Math.min(mid1 < n1 ? nums1[mid1] : Integer.MAX_VALUE, mid2 < n2 ? nums2[mid2] : Integer.MAX_VALUE);

        return (res1 + res2) / 2.0;
    }
}
// @lc code=end
