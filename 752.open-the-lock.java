import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>();
        Stream.of(deadends).forEach(deadendsSet::add);
        if (deadendsSet.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        Deque<String> queue = new ArrayDeque<>();
        queue.addLast("0000");

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int oneLevel = queue.size();
            for (int s = 0; s < oneLevel; s++) {
                String current = queue.pollFirst();
                for (int i = 0; i < 4; i++) {
                    String attempt = forwardRotate(current, i);
                    if (attempt.equals(target)) {
                        return level;
                    }
                    if (!visited.contains(attempt) && !deadendsSet.contains(attempt)) {
                        visited.add(attempt);
                        queue.add(attempt);
                    }
                    attempt = backwardRotate(current, i);
                    if (attempt.equals(target)) {
                        return level;
                    }
                    if (!visited.contains(attempt) && !deadendsSet.contains(attempt)) {
                        visited.add(attempt);
                        queue.add(attempt);
                    }
                }
            }
        }

        return -1;
    }

    private static String forwardRotate(String original, int pos) {
        char[] originalChars = original.toCharArray();
        char target = original.charAt(pos);
        int num = target - '0';
        num = (num + 1) % 10;
        originalChars[pos] = (char) (num + '0');
        return new String(originalChars);
    }

    private static String backwardRotate(String original, int pos) {
        char[] originalChars = original.toCharArray();
        char target = original.charAt(pos);
        int num = target - '0';
        num = (num - 1 + 10) % 10;
        originalChars[pos] = (char) (num + '0');
        return new String(originalChars);
    }
}
// @lc code=end
