/*
 * @lc app=leetcode id=277 lang=java
 *
 * [277] Find the Celebrity
 */

// @lc code=start
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    graph[i][j] = 1;
                    graph[i][n] += 1;
                    graph[n][j] += 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (graph[i][n] == 0 && graph[n][i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end
