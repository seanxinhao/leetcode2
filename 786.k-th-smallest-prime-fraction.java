import java.util.Arrays;

/*
 * @lc app=leetcode id=786 lang=java
 *
 * [786] K-th Smallest Prime Fraction
 */

// @lc code=start
class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        Arrays.sort(A);

        double left = 0;
        double right = 1;

        while (left < right) {
            double mid = left + (right - left) / 2;
            int place = 0;
            int a = 0;
            int b = 1;
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    double value = (double) A[i] / A[j];
                    if (value >= mid) {
                        break;
                    } else {
                        place++;
                        if (value > (double) a / b) {
                            a = A[i];
                            b = A[j];
                        }
                    }
                }
            }

            if (place == K) {
                int[] res = { a, b };
                return res;
            } else if (place < K) {
                left = mid;
            } else {
                right = mid;
            }
        }

        int[] res = { 0, 0 };
        return res;
    }
}
// @lc code=end
