import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max = IntStream.of(piles).max().getAsInt();

        int left = 1;
        int right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int midHours = getHours(piles, mid);
            if (midHours <= H && (mid == 1 || getHours(piles, mid - 1) > H)) {
                return mid;
            } else if (midHours <= H) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int getHours(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / k;
            if (pile % k != 0) {
                hours++;
            }
        }
        return hours;
    }
}
// @lc code=end
