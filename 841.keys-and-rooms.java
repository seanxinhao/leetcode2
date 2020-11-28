import java.util.List;

/*
 * @lc app=leetcode id=841 lang=java
 *
 * [841] Keys and Rooms
 */

// @lc code=start
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visit(rooms, visited, 0);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private void visit(List<List<Integer>> rooms, boolean[] visited, int i) {
        if (i >= rooms.size() || i < 0 || visited[i]) {
            return;
        }
        visited[i] = true;
        List<Integer> keys = rooms.get(i);
        for (int key : keys) {
            visit(rooms, visited, key);
        }
    }
}
// @lc code=end
