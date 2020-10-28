import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode id=934 lang=java
 *
 * [934] Shortest Bridge
 */

// @lc code=start
class Solution {
    public int shortestBridge(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] signMap = new int[m][];
        for (int i = 0; i < m; i++) {
            signMap[i] = new int[n];
            Arrays.fill(signMap[i], 0);
        }

        int count = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1 && signMap[i][j] == 0) {
                    bfs(A, signMap, count, i, j);
                    count++;
                }
            }
        }

        int[][] stepMap = new int[m][];
        for (int i = 0; i < m; i++) {
            stepMap[i] = new int[n];
            for (int j = 0; j < n; j++) {
                if (signMap[i][j] == 1) {
                    stepMap[i][j] = 0;
                } else {
                    stepMap[i][j] = Integer.MAX_VALUE - m * n;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    stepMap[i][j] = Math.min(stepMap[i][j], stepMap[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    stepMap[i][j] = Math.min(stepMap[i][j], stepMap[i][j - 1] + 1);
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    stepMap[i][j] = Math.min(stepMap[i][j], stepMap[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    stepMap[i][j] = Math.min(stepMap[i][j], stepMap[i][j + 1] + 1);
                }
            }
        }

        int minStep = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (signMap[i][j] == 2) {
                    if (stepMap[i][j] < minStep) {
                        minStep = stepMap[i][j];
                    }
                }
            }
        }

        return minStep - 1;
    }

    public static void bfs(int[][] map, int[][] signMap, int sign, int starti, int startj) {
        int m = map.length;
        int n = map[0].length;
        if (signMap[starti][startj] == sign) {
            return;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(Node.build(starti, startj));
        signMap[starti][startj] = sign;
        while (!queue.isEmpty()) {
            Node current = queue.pollFirst();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == j || i + j == 0) {
                        continue;
                    }
                    int nexti = current.i + i;
                    int nextj = current.j + j;
                    if (nexti < 0 || nexti >= m || nextj < 0 || nextj >= n) {
                        continue;
                    }
                    if (map[nexti][nextj] == 1 && signMap[nexti][nextj] != sign) {
                        signMap[nexti][nextj] = sign;
                        queue.add(Node.build(nexti, nextj));
                    }
                }
            }
        }
    }

    static class Node {
        int i;
        int j;

        public static Node build(int i, int j) {
            Node n = new Node();
            n.i = i;
            n.j = j;
            return n;
        }
    }
}
// @lc code=end
