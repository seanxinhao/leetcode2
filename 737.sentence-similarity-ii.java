import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=737 lang=java
 *
 * [737] Sentence Similarity II
 */

// @lc code=start
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        int n = words1.length;
        UnionFindSet ufs = new UnionFindSet();

        for (List<String> pair : pairs) {
            String a = pair.get(0);
            String b = pair.get(1);
            ufs.union(a, a);
            ufs.union(a, b);
            ufs.union(b, b);
        }

        for (int i = 0; i < n; i++) {
            String a = words1[i];
            String b = words2[i];
            if (!ufs.find(a).equals(ufs.find(b))) {
                return false;
            }
        }

        return true;
    }

    class UnionFindSet {
        Map<String, String> parents = new HashMap<>();

        public String find(String w) {
            if (!parents.containsKey(w)) {
                parents.put(w, w);
                return w;
            } else {
                String p = parents.get(w);
                if (p.equals(w)) {
                    return p;
                } else {
                    return parents.get(find(p));
                }
            }
        }

        public void union(String a, String b) {
            String pa = find(a);
            String pb = find(b);
            if (!pa.equals(pb)) {
                parents.put(pa, pb);
            }
        }
    }
}
// @lc code=end
