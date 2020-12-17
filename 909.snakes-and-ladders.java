/*
 * @lc app=leetcode id=909 lang=java
 *
 * [909] Snakes and Ladders
 */

// @lc code=start
class Solution {
    private int n;

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        this.n = n;
        int counter = 0;
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int[] start = new int[] { n - 1, 0 };
        q.addLast(1);
        visited.add(1);
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                int currNum = q.removeFirst();
                if (currNum == n * n) {
                    min = Math.min(min, counter);
                }
                for (int j = 1; j <= 6; j++) {
                    int nextNum = currNum + j;
                    if (nextNum <= n * n) {
                        int[] nextPos = getPosFromNum(nextNum);
                        int boardNum = board[nextPos[0]][nextPos[1]];
                        if (boardNum == -1) {
                            if (!visited.contains(nextNum)) {
                                q.addLast(nextNum);
                                visited.add(nextNum);
                            }
                        } else {
                            if (!visited.contains(boardNum)) {
                                q.addLast(boardNum);
                                visited.add(boardNum);
                            }
                        }
                    }
                }
            }
            counter++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int[] getPosFromNum(int num) {
        int[] pos = new int[2];
        pos[0] = n - 1 - (num - 1) / n;
        boolean isReverse = pos[0] % 2 == n % 2;
        int colOff = (num - 1) % n;
        if (!isReverse) {
            pos[1] = colOff;
        } else {
            pos[1] = n - colOff - 1;
        }
        return pos;
    }
}
// @lc code=end
