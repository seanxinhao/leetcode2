import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {

    private boolean[][] palindromeTable;

    public List<List<String>> partition(String s) {
        int n = s.length();
        palindromeTable = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (s.charAt(j) == s.charAt(j + i) && (i <= 1 || palindromeTable[j + 1][j + i - 1])) {
                    palindromeTable[j][j + i] = true;
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), s, 0);
        return ans;
    }

    public void helper(List<List<String>> ans, List<String> curr, String s, int start) {
        int n = s.length();
        if (start == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < n; i++) {
            if (palindromeTable[start][i]) {
                curr.add(s.substring(start, i + 1));
                helper(ans, curr, s, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
// @lc code=end
