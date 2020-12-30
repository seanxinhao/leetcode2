/*
 * @lc app=leetcode id=1298 lang=java
 *
 * [1298] Maximum Candies You Can Get from Boxes
 */

// @lc code=start
class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] boxes = new boolean[n];
        boolean[] akeys = new boolean[n];
        for (int i = 0; i < n; i++) {
            akeys[i] = status[i] == 1;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int box : initialBoxes) {
            boxes[box] = true;
            if (akeys[box]) {
                q.addLast(box);
            }
        }

        int res = 0;
        while (!q.isEmpty()) {
            int curr = q.removeFirst();
            res += candies[curr];
            for (int newBox : containedBoxes[curr]) {
                boxes[newBox] = true;
                if (akeys[newBox]) {
                    q.addLast(newBox);
                }
            }
            for (int key : keys[curr]) {
                if (!akeys[key] && boxes[key]) {
                    q.addLast(key);
                }
                akeys[key] = true;
            }
        }

        return res;
    }
}
// @lc code=end
