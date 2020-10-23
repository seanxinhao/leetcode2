/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (left < s.length() && !Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
            }
            while (right >= 0 && !Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
            }
            if (left < s.length() && right >= 0) {
                char leftChar = Character.toLowerCase(s.charAt(left));
                char rightChar = Character.toLowerCase(s.charAt(right));
                if (leftChar != rightChar) {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end
