import java.util.Arrays;

/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][];
        for (int i = 0; i < board.length; i++) {
            visited[i] = new boolean[board[0].length];
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int depth) {
        if (depth == word.length()) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(depth) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean result = dfs(board, visited, i - 1, j, word, depth + 1)
                || dfs(board, visited, i, j - 1, word, depth + 1) || dfs(board, visited, i, j + 1, word, depth + 1)
                || dfs(board, visited, i + 1, j, word, depth + 1);
        visited[i][j] = false;
        return result;
    }
}
// @lc code=end
