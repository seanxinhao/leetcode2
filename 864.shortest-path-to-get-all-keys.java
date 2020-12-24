/*
 * @lc app=leetcode id=864 lang=java
 *
 * [864] Shortest Path to Get All Keys
 */

// @lc code=start
class Solution {
    private int m;
    private int n;

    public int shortestPathAllKeys(String[] grid) {
        m = grid.length;
        n = grid[0].length();
        int[][] dirs = new int[][] { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

        int totalKeys = 0;
        int starti = 0;
        int startj = 0;

        char[][] graph = new char[m][n];
        for (int i = 0; i < m; i++) {
            graph[i] = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                if (graph[i][j] >= 'a' && graph[i][j] <= 'f') {
                    totalKeys++;
                }
                if (graph[i][j] == '@') {
                    starti = i;
                    startj = j;
                }
            }
        }

        Deque<State> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        State start = new State(starti, startj);
        q.addLast(start);
        visited.add(start.toString());

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                State curr = q.removeFirst();
                if (curr.keys.size() == totalKeys) {
                    return steps;
                } else {
                    for (int[] dir : dirs) {
                        int nexti = curr.i + dir[0];
                        int nextj = curr.j + dir[1];
                        if (canPass(curr, nexti, nextj, graph)) {
                            State next = new State(nexti, nextj);
                            next.keys.addAll(curr.keys);
                            char nextPos = graph[nexti][nextj];
                            if (nextPos >= 'a' && nextPos <= 'f') {
                                next.keys.add(nextPos);
                            }
                            if (!visited.contains(next.toString())) {
                                q.addLast(next);
                                visited.add(next.toString());
                            }
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean canPass(State curr, int nexti, int nextj, char[][] graph) {
        if (nexti < 0 || nexti >= m || nextj < 0 || nextj >= n) {
            return false;
        }
        char nextPos = graph[nexti][nextj];
        if (nextPos == '#') {
            return false;
        }
        if (nextPos >= 'A' && nextPos <= 'F') {
            char needKey = (char) ((int) nextPos + ('a' - 'A'));
            return curr.keys.contains(needKey);
        }
        return true;
    }

    class State {
        int i;
        int j;
        Set<Character> keys;

        public State(int i, int j) {
            this.i = i;
            this.j = j;
            keys = new HashSet<>();
        }

        public String toString() {
            return i + "," + j + "[" + keys.stream().map(String::valueOf).collect(Collectors.joining());
        }
    }
}
// @lc code=end
