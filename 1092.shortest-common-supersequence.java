/*
 * @lc app=leetcode id=1092 lang=java
 *
 * [1092] Shortest Common Supersequence 
 */

// @lc code=start
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        int[][] lcs = new int[l1 + 1][l2 + 1];
        // Storing strings intemediate results will cause MLE.
        // String[][] dp = new String[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                lcs[i][j] = str1.charAt(i - 1) == str2.charAt(j - 1) ? lcs[i - 1][j - 1] + 1
                        : Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }

        StringBuffer sb = new StringBuffer();
        int i = l1;
        int j = l2;
        // Reverse LCS trace
        while (i > 0 || j > 0) {
            if (i == 0) {
                sb.append(str2.charAt(j - 1));
                j--;
            } else if (j == 0) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    sb.append(str1.charAt(i - 1));
                    i--;
                    j--;
                } else {
                    if (lcs[i][j] == lcs[i - 1][j]) {
                        sb.append(str1.charAt(i - 1));
                        i--;
                    } else if (lcs[i][j] == lcs[i][j - 1]) {
                        sb.append(str2.charAt(j - 1));
                        j--;
                    }
                }
            }
        }

        return sb.reverse().toString();
    }
}
// @lc code=end
