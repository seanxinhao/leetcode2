import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> results = new ArrayList<>();
        results.add(0);
        if (n == 0) {
            return results;
        }
        results.add(1);
        if (n == 1) {
            return results;
        }
        for (int i = 2; i <= n; i++) {
            int size = results.size() - 1;
            for (int j = size; j >= 0; j--) {
                results.add(results.get(j) + (1 << (i - 1)));
            }
        }

        return results;
    }
}
// @lc code=end
