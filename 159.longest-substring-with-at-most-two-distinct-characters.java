import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=159 lang=java
 *
 * [159] Longest Substring with At Most Two Distinct Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int localMax = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    localMax++;
                } else if (!set.contains(s.charAt(j)) && set.size() < 2) {
                    set.add(s.charAt(j));
                    localMax++;
                } else {
                    break;
                }
            }
            max = Math.max(max, localMax);
        }

        return max;
    }
}
// @lc code=end
