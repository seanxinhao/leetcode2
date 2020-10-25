import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 */

// @lc code=start
class Solution {

    // left1 -> the first [left1, right] to make count of it is K;
    // left2 -> the first [left2, right] to make count of it is not K;
    // ending by right there would be {left2 - left1} valid subarraies.
    public int subarraysWithKDistinct(int[] A, int K) {
        int totalCount = 0;
        int left1 = 0;
        int left2 = 0;
        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();
        for (int right = 0; right < A.length; right++) {
            count1.put(A[right], count1.getOrDefault(A[right], 0) + 1);
            count2.put(A[right], count2.getOrDefault(A[right], 0) + 1);
            while (count1.size() > K) {
                count1.put(A[left1], count1.get(A[left1]) - 1);
                if (count1.get(A[left1]) == 0) {
                    count1.remove(A[left1]);
                }
                left1++;
            }
            while (count2.size() >= K) {
                count2.put(A[left2], count2.get(A[left2]) - 1);
                if (count2.get(A[left2]) == 0) {
                    count2.remove(A[left2]);
                }
                left2++;
            }
            totalCount += left2 - left1;
        }
        return totalCount;
    }
}
// @lc code=end
