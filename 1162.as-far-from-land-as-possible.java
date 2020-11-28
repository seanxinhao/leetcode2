import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=1162 lang=java
 *
 * [1162] As Far from Land as Possible
 */

// @lc code=start
class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int max = -1;
        boolean[][] visited = new boolean[m][n];
        Deque<Node> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.addLast(Node.build(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int k = 0; k < s; k++) {
                Node curr = q.removeFirst();
                if (grid[curr.i][curr.j] == 0) {
                    max = Math.max(max, count);
                }
                if (curr.i - 1 >= 0 && grid[curr.i - 1][curr.j] == 0 && !visited[curr.i - 1][curr.j]) {
                    q.addLast(Node.build(curr.i - 1, curr.j));
                    visited[curr.i - 1][curr.j] = true;
                }
                if (curr.j - 1 >= 0 && grid[curr.i][curr.j - 1] == 0 && !visited[curr.i][curr.j - 1]) {
                    q.addLast(Node.build(curr.i, curr.j - 1));
                    visited[curr.i][curr.j - 1] = true;
                }
                if (curr.i + 1 < m && grid[curr.i + 1][curr.j] == 0 && !visited[curr.i + 1][curr.j]) {
                    q.addLast(Node.build(curr.i + 1, curr.j));
                    visited[curr.i + 1][curr.j] = true;
                }
                if (curr.j + 1 < n && grid[curr.i][curr.j + 1] == 0 && !visited[curr.i][curr.j + 1]) {
                    q.addLast(Node.build(curr.i, curr.j + 1));
                    visited[curr.i][curr.j + 1] = true;
                }
            }
            count++;
        }

        return max;
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
