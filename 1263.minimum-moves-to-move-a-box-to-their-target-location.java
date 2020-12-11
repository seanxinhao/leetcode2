/*
 * @lc app=leetcode id=1263 lang=java
 *
 * [1263] Minimum Moves to Move a Box to Their Target Location
 */

// @lc code=start
class Solution {
    private int minPath;
    private int[][][][] visited;

    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        minPath = Integer.MAX_VALUE;
        visited = new int[m][n][m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    Arrays.fill(visited[i][j][k], Integer.MAX_VALUE);
                }
            }
        }
        int[] box = new int[2];
        int[] shopper = new int[2];
        int[] target = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                if (c == 'S') {
                    shopper[0] = i;
                    shopper[1] = j;
                    grid[i][j] = '.';
                }
                if (c == 'B') {
                    box[0] = i;
                    box[1] = j;
                    grid[i][j] = '.';
                }
                if (c == 'T') {
                    target[0] = i;
                    target[1] = j;
                    grid[i][j] = '.';
                }
            }
        }
        helper(grid, box, shopper, target, 0);
        return minPath == Integer.MAX_VALUE ? -1 : minPath;
    }

    private void helper(char[][] map, int[] box, int[] shopper, int[] target, int pushCount) {
        if (box[0] == target[0] && box[1] == target[1]) {
            minPath = Math.min(minPath, pushCount);
            return;
        }
        if (pushCount > visited[shopper[0]][shopper[1]][box[0]][box[1]]) {
            return;
        }
        visited[shopper[0]][shopper[1]][box[0]][box[1]] = pushCount;

        int m = map.length;
        int n = map[0].length;

        int[] left = new int[] { box[0], box[1] - 1 };
        int[] right = new int[] { box[0], box[1] + 1 };
        int[] up = new int[] { box[0] - 1, box[1] };
        int[] down = new int[] { box[0] + 1, box[1] };

        if (valid(left, m, n) && valid(right, m, n) && map[left[0]][left[1]] == '.' && map[right[0]][right[1]] == '.') {
            // from left to right.
            if (shopperReachable(map, shopper, box, left)) {
                helper(map, right, box, target, pushCount + 1);
            }
            // from right to left.
            if (shopperReachable(map, shopper, box, right)) {
                helper(map, left, box, target, pushCount + 1);
            }
        }
        if (valid(up, m, n) && valid(down, m, n) && map[up[0]][up[1]] == '.' && map[down[0]][down[1]] == '.') {
            // from up to down.
            if (shopperReachable(map, shopper, box, up)) {
                helper(map, down, box, target, pushCount + 1);
            }
            // from down to up.
            if (shopperReachable(map, shopper, box, down)) {
                helper(map, up, box, target, pushCount + 1);
            }
        }
    }

    private boolean valid(int[] pos, int m, int n) {
        return pos[0] >= 0 && pos[0] < m && pos[1] >= 0 && pos[1] < n;
    }

    private boolean shopperReachable(char[][] map, int[] shopper, int[] box, int[] target) {
        int m = map.length;
        int n = map[0].length;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(shopper);
        visited[shopper[0]][shopper[1]] = true;
        while (!q.isEmpty()) {
            int[] curr = q.removeFirst();
            visited[curr[0]][curr[1]] = true;
            if (curr[0] == target[0] && curr[1] == target[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int i = curr[0] + dir[0];
                int j = curr[1] + dir[1];
                if (i >= 0 && i < m && j >= 0 && j < n && map[i][j] == '.' && !(i == box[0] && j == box[1])
                        && !visited[i][j]) {
                    q.addLast(new int[] { i, j });
                }
            }
        }
        return false;
    }
}
// @lc code=end
