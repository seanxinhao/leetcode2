import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int[][] dist = new int[wordList.size()][];
        for (int i = 0; i < wordList.size(); i++) {
            dist[i] = new int[wordList.size()];
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = calculateDist(wordList.get(i), wordList.get(j));
                }
            }
        }

        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < wordList.size(); i++) {
            int startDist = calculateDist(beginWord, wordList.get(i));
            if (startDist == 1) {
                boolean[] visited = new boolean[wordList.size()];
                Arrays.fill(visited, false);
                Deque<Node> queue = new ArrayDeque<>();
                queue.addLast(Node.build(i, 2));
                visited[i] = true;
                while (!queue.isEmpty()) {
                    Node current = queue.pollFirst();
                    if (wordList.get(current.index).equals(endWord)) {
                        if (current.distance < shortest) {
                            shortest = current.distance;
                            break;
                        }
                    }
                    for (int j = 0; j < wordList.size(); j++) {
                        if (dist[current.index][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            queue.add(Node.build(j, current.distance + 1));
                        }
                    }
                }
            }
        }

        if (shortest == Integer.MAX_VALUE) {
            return 0;
        }

        return shortest;
    }

    private int calculateDist(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    static class Node {
        int index;
        int distance;

        public static Node build(int index, int distance) {
            Node n = new Node();
            n.index = index;
            n.distance = distance;
            return n;
        }
    }
}
// @lc code=end
