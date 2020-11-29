import java.util.Comparator;
import java.util.stream.Stream;

/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution {
    private static final Comparator<String> logComparator = (a, b) -> {
        int starta = a.indexOf(' ');
        int startb = b.indexOf(' ');
        int i = starta + 1;
        int j = startb + 1;

        char ac = a.charAt(i);
        char bc = b.charAt(j);

        if (Character.isDigit(ac) && Character.isDigit(bc)) {
            return 0;
        } else if (Character.isDigit(ac)) {
            return 1;
        } else if (Character.isDigit(bc)) {
            return -1;
        } else {
            int res1 = a.substring(i).compareTo(b.substring(j));
            if (res1 != 0) {
                return res1;
            } else {
                return a.substring(0, starta).compareTo(b.substring(0, startb));
            }
        }
    };

    public String[] reorderLogFiles(String[] logs) {
        return Stream.of(logs).sorted(logComparator).toArray(String[]::new);
    }
}
// @lc code=end
