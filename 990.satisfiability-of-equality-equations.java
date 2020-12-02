/*
 * @lc app=leetcode id=990 lang=java
 *
 * [990] Satisfiability of Equality Equations
 */

// @lc code=start
class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFindSet ufs = new UnionFindSet();
        for (String equ : equations) {
            if (equ.charAt(1) == '=') {
                int a = equ.charAt(0) - 'a';
                int b = equ.charAt(3) - 'a';
                ufs.union(a, b);
            }
        }
        for (String equ : equations) {
            if (equ.charAt(1) == '!') {
                int a = equ.charAt(0) - 'a';
                int b = equ.charAt(3) - 'a';
                if (ufs.find(a) == ufs.find(b)) {
                    return false;
                }
            }
        }
        return true;
    }

    class UnionFindSet {
        int[] parent = new int[26];

        public UnionFindSet() {
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }
        }

        public int find(int pos) {
            if (parent[pos] == pos) {
                return pos;
            } else {
                return find(parent[pos]);
            }
        }

        public void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi != pj) {
                parent[pi] = pj;
            }
        }
    }
}
// @lc code=end
