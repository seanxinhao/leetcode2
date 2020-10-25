import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    private final Map<Character, char[]> mappings;

    public Solution() {
        mappings = new HashMap<>();
        mappings.put('2', new char[] { 'a', 'b', 'c' });
        mappings.put('3', new char[] { 'd', 'e', 'f' });
        mappings.put('4', new char[] { 'g', 'h', 'i' });
        mappings.put('5', new char[] { 'j', 'k', 'l' });
        mappings.put('6', new char[] { 'm', 'n', 'o' });
        mappings.put('7', new char[] { 'p', 'q', 'r', 's' });
        mappings.put('8', new char[] { 't', 'u', 'v' });
        mappings.put('9', new char[] { 'w', 'x', 'y', 'z' });
    }

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        helper(results, new StringBuilder(), digits, 0);
        return results;
    }

    public void helper(List<String> results, StringBuilder previous, String digits, int pos) {
        if (pos == digits.length()) {
            String result = previous.toString();
            if (!result.isEmpty()) {
                results.add(result);
            }
            return;
        }
        char digit = digits.charAt(pos);
        char[] chars = mappings.get(digit);
        for (int i = 0; i < chars.length; i++) {
            previous.append(chars[i]);
            helper(results, previous, digits, pos + 1);
            previous.deleteCharAt(previous.length() - 1);
        }
    }
}
// @lc code=end
