/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 */

// @lc code=start
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[][] graph = new int[N + 1][N + 1];

        for (int[] pair : trust) {
            int a = pair[0];
            int b = pair[1];
            graph[a][b] = 1;
            graph[0][b] += 1;
            graph[a][0] += 1;
        }

        for (int i = 1; i <= N; i++) {
            if (graph[i][0] == 0 && graph[0][i] == N - 1) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end
