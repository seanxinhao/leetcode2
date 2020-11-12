import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 */

// @lc code=start
class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.sort(words, Comparator.comparing(e -> e.length()));

        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        return IntStream.of(dp).max().getAsInt();
    }

    private boolean isPredecessor(String a, String b) {
        if (a.length() + 1 != b.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            } else {
                count++;
            }
            j++;
        }
        return count <= 1;
    }
}
// @lc code=end
