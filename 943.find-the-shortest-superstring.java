/*
 * @lc app=leetcode id=943 lang=java
 *
 * [943] Find the Shortest Superstring
 */

// @lc code=start
class Solution {
    private int minLength = Integer.MAX_VALUE;
    private String result = "";

    public String shortestSuperstring(String[] A) {
        helper("", A, new boolean[A.length], 0);

        return result;
    }

    private void helper(String prev, String[] A, boolean used[], int depth) {
        if (depth == A.length) {
            if (prev.length() < minLength) {
                minLength = prev.length();
                result = prev;
            }
            return;
        }

        if (prev.length() >= minLength) {
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            String appended = appendSubString(prev, A[i]);
            helper(appended, A, used, depth + 1);
            used[i] = false;
        }
    }

    private String appendSubString(String prev, String sub) {
        for (int i = Math.max(0, prev.length() - sub.length()); i < prev.length(); i++) {
            if (prev.substring(i).equals(sub.substring(0, prev.length() - i))) {
                return prev + sub.substring(prev.length() - i);
            }
        }
        return prev + sub;
    }
}
// @lc code=end
