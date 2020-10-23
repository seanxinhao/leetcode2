/*
 * @lc app=leetcode id=917 lang=java
 *
 * [917] Reverse Only Letters
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] charArray = S.toCharArray();
        int left = 0;
        int right = S.length() - 1;
        while (left <= right) {
            while (left < S.length() && !Character.isAlphabetic(S.charAt(left))) {
                left++;
            }
            while (right >= 0 && !Character.isAlphabetic(S.charAt(right))) {
                right--;
            }
            if (left <= right && left < S.length() && right >= 0) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
            }
            left++;
            right--;
        }
        return String.valueOf(charArray);
    }
}
// @lc code=end
