import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=839 lang=java
 *
 * [839] Similar String Groups
 */

// @lc code=start
class Solution {
    public int numSimilarGroups(String[] strs) {
        UnionFindSet ufs = new UnionFindSet(strs);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    ufs.union(i, j);
                }
            }
        }
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            sets.add(ufs.find(i));
        }
        return sets.size();
    }

    class UnionFindSet {
        int[] parrents;
        String[] elements;

        public UnionFindSet(String[] strs) {
            int n = strs.length;
            parrents = new int[n];
            elements = strs;
            for (int i = 0; i < n; i++) {
                parrents[i] = i;
            }
        }

        public int find(int index) {
            if (parrents[index] == index) {
                return index;
            } else {
                return find(parrents[index]);
            }
        }

        public void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi != pj) {
                parrents[pj] = pi;
            }
        }
    }

    private boolean isSimilar(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        List<Integer> diffs = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffs.add(i);
            }
        }
        if (diffs.isEmpty()) {
            return true;
        }
        if (diffs.size() != 2) {
            return false;
        }
        if (a.charAt(diffs.get(0)) == b.charAt(diffs.get(1)) && a.charAt(diffs.get(1)) == b.charAt(diffs.get(0))) {
            return true;
        }
        return false;
    }
}
// @lc code=end
