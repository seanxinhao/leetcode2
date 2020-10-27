import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        helper(results, n, n, new StringBuilder());
        return results;
    }

    private static void helper(List<String> results, int opening, int closing, StringBuilder prev) {
        if (opening > closing) {
            return;
        }
        if (opening == 0 && closing == 0) {
            if (verify(prev.toString())) {
                results.add(prev.toString());
            }
            return;
        }
        if (opening > 0) {
            prev.append("(");
            helper(results, opening - 1, closing, prev);
            prev.deleteCharAt(prev.length() - 1);
        }
        if (closing > 0) {
            prev.append(")");
            helper(results, opening, closing - 1, prev);
            prev.deleteCharAt(prev.length() - 1);
        }
    }

    private static boolean verify(String parentheses) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : parentheses.toCharArray()) {
            if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end
