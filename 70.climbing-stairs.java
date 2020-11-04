/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int pn = 0;
        int pnm1 = 1;
        int pnm2 = 1;
        for (int i = 1; i < n; i++) {
            pn = pnm1 + pnm2;
            pnm2 = pnm1;
            pnm1 = pn;
        }
        return pn;
    }
}
// @lc code=end
