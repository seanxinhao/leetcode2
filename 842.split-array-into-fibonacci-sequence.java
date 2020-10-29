import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=842 lang=java
 *
 * [842] Split Array into Fibonacci Sequence
 */

// @lc code=start
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> results = new ArrayList<>();
        helper(results, S, 0, (S.length() - 1) / 2);
        return results;
    }

    private static boolean helper(List<Integer> answer, String s, int start, int max) {
        if (start >= s.length()) {
            return true;
        }
        if (answer.size() >= 2) {
            int target = answer.get(answer.size() - 1) + answer.get(answer.size() - 2);
            String targetStr = String.valueOf(target);
            int i = start;
            for (int t = 0; t < targetStr.length(); t++) {
                if (i >= s.length() || s.charAt(i) != targetStr.charAt(t)) {
                    return false;
                }
                i++;
            }
            answer.add(target);
            if (helper(answer, s, i, max)) {
                return true;
            }
            answer.remove(answer.size() - 1);
            return false;
        }
        for (int end = start + 1; end <= Math.min(start + max, s.length()); end++) {
            String numStr = s.substring(start, end);
            if ((numStr.length() > 1 && numStr.startsWith("0")) || numStr.length() > 9) {
                return false;
            } else {
                answer.add(Integer.parseInt(numStr));
                if (helper(answer, s, end, max)) {
                    return true;
                }
                answer.remove(answer.size() - 1);
            }
        }
        return false;
    }
}
// @lc code=end
