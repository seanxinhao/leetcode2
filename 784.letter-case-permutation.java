import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=784 lang=java
 *
 * [784] Letter Case Permutation
 */

// @lc code=start
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> results = new ArrayList<>();
        helper(results, new StringBuilder(), S, 0);
        return results;
    }

    private static void helper(List<String> results, StringBuilder previous, String S, int depth) {
        if (depth == S.length()) {
            results.add(previous.toString());
            return;
        }
        char c = S.charAt(depth);
        if (Character.isAlphabetic(c)) {
            previous.append(Character.toLowerCase(c));
            helper(results, previous, S, depth + 1);
            previous.deleteCharAt(previous.length() - 1);
            previous.append(Character.toUpperCase(c));
            helper(results, previous, S, depth + 1);
            previous.deleteCharAt(previous.length() - 1);
        } else {
            previous.append(c);
            helper(results, previous, S, depth + 1);
            previous.deleteCharAt(previous.length() - 1);
        }
    }
}
// @lc code=end
