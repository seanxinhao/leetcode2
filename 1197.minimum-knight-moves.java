class Solution {
  public int minKnightMoves(int x, int y) {
    int[][] dirs = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 } };
    x = Math.abs(x);
    y = Math.abs(y);
    int count = 0;
    int[] start = new int[] { 0, 0 };

    Deque<int[]> q = new ArrayDeque<>();
    Set<int[]> visited = new HashSet<>();

    q.addLast(start);
    visited.add(getKey(start));

    while (!q.isEmpty()) {
      int s = q.size();
      for (int i = 0; i < s; i++) {
        int[] curr = q.removeFirst();
        if (curr[0] == x && curr[1] == y) {
          return count;
        }
        for (int[] dir : dirs) {
          int[] next = new int[] { curr[0] + dir[0], curr[1] + dir[1] };
          if (!visited.contains(getKey(next)) && next[0] >= -1 && next[1] >= -1) {
            visited.add(getKey(next));
            q.addLast(next);
          }
        }
      }
      count++;
    }
    return -1;
  }

  private String getKey(int[] coord) {
    return coord[0] + " " + coord[1];
  }
}