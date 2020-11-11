import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    private boolean[][] substringMatch;
    private String[][] substrings;
    private Map<String, List<String>> mem;

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        if (s.length() == 0) {
            return ans;
        }
        Set<String> dict = new HashSet<>(wordDict);
        substringMatch = new boolean[s.length()][s.length() + 1];
        substrings = new String[s.length()][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (i < j) {
                    substrings[i][j] = s.substring(i, j);
                    substringMatch[i][j] = dict.contains(substrings[i][j]);
                }
            }
        }
        mem = new HashMap<>();
        return wordBreak(s, dict);
    }

    private List<String> wordBreak(String s, Set<String> dict) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        List<String> ans = new ArrayList<>();
        if (dict.contains(s)) {
            ans.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            if (substringMatch[i][s.length()]) {
                String sub = substrings[i][s.length()];
                List<String> prefix = wordBreak(substrings[0][i], dict);
                for (String wordPrefix : prefix) {
                    ans.add(wordPrefix + " " + sub);
                }
            }
        }
        mem.put(s, ans);
        return ans;
    }
}
// @lc code=end
