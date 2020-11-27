/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                visit(M, n, visited, i);
            }
        }

        return count;
    }

    private void visit(int[][] M, int n, boolean[] visited, int i) {
        if (i >= 0 && i < n) {
            visited[i] = true;
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1 && !visited[j]) {
                    visit(M, n, visited, j);
                }
            }
        }
    }
}
// @lc code=end
