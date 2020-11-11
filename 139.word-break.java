import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        if (n == 0) {
            return wordDict.isEmpty();
        }
        Set<String> dict = new HashSet<>(wordDict);

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                boolean wordMatch = dict.contains(s.substring(i, j + 1));
                boolean prefixMatch = false;
                for (int k = 0; k < i; k++) {
                    if (dp[k][i - 1] == true) {
                        prefixMatch = true;
                    }
                }
                dp[i][j] = wordMatch && (i == 0 ? true : prefixMatch);
            }
        }

        for (int i = 0; i < n; i++) {
            if (dp[i][n - 1] == true) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
