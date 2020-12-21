/*
 * @lc app=leetcode id=880 lang=java
 *
 * [880] Decoded String at Index
 */

// @lc code=start
class Solution {
    public String decodeAtIndex(String S, int K) {
        int n = S.length();
        long size = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                size *= Character.getNumericValue(c);
            } else {
                size++;
            }
        }

        int k = K;
        for (int i = n - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                size /= Character.getNumericValue(c);
                k %= size;
            } else {
                if (k % size == 0) {
                    return Character.toString(c);
                }
                size--;
            }
        }

        return "";
    }
}
// @lc code=end
