import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answers = new ArrayList<>();
        helper(answers, new ArrayList<>(), s, 0);
        return answers;
    }

    private static void helper(List<List<String>> answers, List<String> answer, String s, int depth) {
        if (depth >= s.length()) {
            if (!answer.isEmpty()) {
                answers.add(new ArrayList<>(answer));
            }
            return;
        }
        for (int i = 1; depth + i <= s.length(); i++) {
            String attempt = s.substring(depth, depth + i);
            if (isPalindrome(attempt)) {
                answer.add(attempt);
                helper(answers, answer, s, depth + i);
                answer.remove(answer.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end
