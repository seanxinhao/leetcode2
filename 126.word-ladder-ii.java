import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        List<List<String>> answers = new ArrayList<>();
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < wordList.size(); i++) {
            int startDist = calculateDist(beginWord, wordList.get(i));
            if (startDist == 1) {
                Deque<Node> queue = new ArrayDeque<>();
                LinkedHashSet<String> initPath = new LinkedHashSet<>();
                initPath.add(beginWord);
                initPath.add(wordList.get(i));
                queue.addLast(Node.build(wordList.get(i), initPath));
                while (!queue.isEmpty()) {
                    Node current = queue.pollFirst();
                    if (current.path.size() > shortest) {
                        continue;
                    }
                    if (current.word.equals(endWord)) {
                        if (current.path.size() <= shortest) {
                            shortest = current.path.size();
                            answers.add(new ArrayList<>(current.path));
                        }
                        continue;
                    }
                    for (String word : getAdjWord(current.word, dictionary)) {
                        if (!current.hasInPath(word)) {
                            LinkedHashSet<String> nextPath = new LinkedHashSet<>(current.path);
                            nextPath.add(word);
                            queue.add(Node.build(word, nextPath));
                        }
                    }
                }
            }
        }

        if (answers.isEmpty()) {
            return answers;
        }

        int filter = shortest;
        return answers.stream().filter(answer -> answer.size() == filter).collect(Collectors.toList());
    }

    private List<String> getAdjWord(String a, Set<String> dictionary) {
        List<String> words = new ArrayList<>();
        char[] primary = a.toCharArray();
        for (int i = 0; i < primary.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char original = primary[i];
                if (c == original) {
                    continue;
                }
                primary[i] = c;
                String attempt = new String(primary);
                if (dictionary.contains(attempt)) {
                    words.add(attempt);
                }
                primary[i] = original;
            }
        }
        return words;
    }

    private int calculateDist(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count == 2) {
                    return 2;
                }
            }
        }
        return count;
    }

    static class Node {
        String word;
        LinkedHashSet<String> path;

        public static Node build(String word, LinkedHashSet<String> path) {
            Node n = new Node();
            n.word = word;
            n.path = path;
            return n;
        }

        public boolean hasInPath(String word) {
            return path.contains(word);
        }
    }
}
// @lc code=end
