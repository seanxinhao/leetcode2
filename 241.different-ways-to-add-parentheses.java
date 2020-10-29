import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {
    private static final Set<Character> validOperators = new HashSet<>(4);

    public Solution() {
        validOperators.add('+');
        validOperators.add('-');
        validOperators.add('*');
    }

    public List<Integer> diffWaysToCompute(String input) {
        return helper(input, 0, input.length() - 1);
    }

    private static List<Integer> helper(String input, int start, int end) {
        List<Integer> answers = new ArrayList<>();
        if (start < 0 || start >= input.length() || end < 0 || end >= input.length() || start > end) {
            return answers;
        }
        boolean hasOperator = false;
        for (int i = start; i <= end; i++) {
            char c = input.charAt(i);
            if (validOperators.contains(c)) {
                hasOperator = true;
                List<Integer> leftAnswer = helper(input, start, i - 1);
                List<Integer> rightAnswer = helper(input, i + 1, end);
                for (int l = 0; l < leftAnswer.size(); l++) {
                    for (int r = 0; r < rightAnswer.size(); r++) {
                        int answer = 0;
                        if (c == '+') {
                            answer = leftAnswer.get(l) + rightAnswer.get(r);
                        } else if (c == '-') {
                            answer = leftAnswer.get(l) - rightAnswer.get(r);
                        } else if (c == '*') {
                            answer = leftAnswer.get(l) * rightAnswer.get(r);
                        }
                        answers.add(answer);
                    }
                }
            }
        }
        if (!hasOperator) {
            answers.add(Integer.parseInt(input.substring(start, end + 1)));
        }
        return answers;
    }
}
// @lc code=end
