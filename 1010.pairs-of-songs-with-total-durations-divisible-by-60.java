/*
 * @lc app=leetcode id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 */

// @lc code=start
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] mod = new int[60];
        for (int t : time) {
            mod[t % 60]++;
        }
        int counter = 0;
        int c = mod[0];
        counter += c * (c - 1) / 2;
        for (int i = 1; i < 30; i++) {
            int c1 = mod[i];
            int c2 = mod[60 - i];
            counter += c1 * c2;
        }
        c = mod[30];
        counter += c * (c - 1) / 2;
        return counter;
    }
}
// @lc code=end
