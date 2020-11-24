import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int max = IntStream.of(weights).max().getAsInt();
        int sum = IntStream.of(weights).sum();

        int left = max;
        int right = sum;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int value = getDays(weights, mid);
            if (value <= D && (mid == 1 || getDays(weights, mid - 1) > D)) {
                return mid;
            } else if (value <= D) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int getDays(int[] weights, int c) {
        int days = 0;
        int load = 0;
        for (int weight : weights) {
            if (load + weight < c) {
                load += weight;
            } else if (load + weight == c) {
                days++;
                load = 0;
            } else {
                days++;
                load = weight;
            }
        }
        if (load > 0) {
            days++;
        }
        return days;
    }
}
// @lc code=end
