import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1042 lang=java
 *
 * [1042] Flower Planting With No Adjacent
 */

// @lc code=start
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        // int[][] graph = new int[n][n]; MLE
        int[] color = new int[n];
        List<List<Integer>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        }
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                for (int x = 1; x <= 4; x++) {
                    boolean ok = true;
                    for (int adj : graph.get(i)) {
                        if (color[adj] == x) {
                            ok = false;
                        }
                    }
                    if (ok) {
                        color[i] = x;
                    }
                }
            }
        }

        return color;
    }
}
// @lc code=end
