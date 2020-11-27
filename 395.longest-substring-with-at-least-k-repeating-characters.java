/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();

        int[] count = new int[26];
        int max = 0;

        for (int i = 0; i < n; i++) {
            int local = 0;
            for (int j = i; j < n; j++) {
                count[s.charAt(j) - 'a']++;
                if (atLeastK(count, k)) {
                    local = Math.max(local, j - i + 1);
                }
            }
            max = Math.max(max, local);
            count = new int[26];
        }

        return max;
    }

    private boolean atLeastK(int[] count, int k) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0 && count[i] < k) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
