import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=734 lang=java
 *
 * [734] Sentence Similarity
 */

// @lc code=start
class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        int n = sentence1.length;
        Map<String, Set<String>> wordMap = new HashMap<>();

        for (List<String> pair : similarPairs) {
            String a = pair.get(0);
            String b = pair.get(1);
            Set<String> v = wordMap.getOrDefault(a, new HashSet<>());
            v.add(b);
            wordMap.put(a, v);
            v = wordMap.getOrDefault(b, new HashSet<>());
            v.add(a);
            wordMap.put(b, v);
        }

        for (int i = 0; i < n; i++) {
            String a = sentence1[i];
            String b = sentence2[i];
            if (!a.equals(b) && (!wordMap.containsKey(a) || !wordMap.get(a).contains(b))) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
