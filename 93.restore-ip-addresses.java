import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        if (s.length() > 12) {
            return results;
        }
        helper(results, new ArrayList<>(), s, 0, 1);
        return results;
    }

    private static void helper(List<String> results, List<String> previous, String s, int depth, int pos) {
        if (depth == s.length()) {
            if (pos == 5) {
                results.add(previous.stream().reduce((a, b) -> a + "." + b).get());
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (depth + i > s.length()) {
                break;
            }
            String num = s.substring(depth, depth + i);
            if (num.length() > 1 && num.startsWith("0")) {
                break;
            }
            int value = Integer.parseInt(num);
            if (value >= 0 && value <= 255) {
                previous.add(num);
                helper(results, previous, s, depth + i, pos + 1);
                previous.remove(previous.size() - 1);
            }
        }
    }
}
// @lc code=end
