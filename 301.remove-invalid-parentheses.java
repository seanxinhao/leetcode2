/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> answers = new ArrayList<>();
        int n = s.length();
        if (n == 0) {
            answers.add("");
            return answers;
        }

        Deque<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.addLast(s);
        visited.add(s);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean valid = false;
            for (int i = 0; i < size; i++) {
                String curr = q.removeFirst();
                if (paired(curr)) {
                    answers.add(curr);
                    valid = true;
                }
                for (int j = 0; j < curr.length(); j++) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < curr.length(); k++) {
                        if (j == k) {
                            continue;
                        }
                        sb.append(curr.charAt(k));
                    }
                    String attempt = sb.toString();
                    if (visited.contains(attempt)) {
                        continue;
                    }
                    visited.add(attempt);
                    q.addLast(attempt);
                }
            }
            if (valid) {
                break;
            }
        }
        return answers;
    }

    private boolean paired(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.getLast();
                if (last == '(') {
                    stack.removeLast();
                } else {
                    stack.addLast(c);
                }
            } else if (c == '(') {
                stack.addLast(c);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end
