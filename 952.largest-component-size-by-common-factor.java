/*
 * @lc app=leetcode id=952 lang=java
 *
 * [952] Largest Component Size by Common Factor
 */

// @lc code=start
class Solution {
    public int largestComponentSize(int[] A) {
        int max = 0;
        for (int a : A) {
            max = Math.max(max, a);
        }
        UnionFindSet ufs = new UnionFindSet(max + 1);
        // Solution of finding GCD got TLE.
        // UnionFindSet ufs = new UnionFindSet(n);
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         if (findGcd(A[i], A[j]) > 1) {
        //             ufs.union(i, j);
        //         }
        //     }
        // }
        for (int a : A) {
            for (int f = 2; f * f <= a; f++) {
                if (a % f == 0) {
                    ufs.union(a, f);
                    ufs.union(a, a / f);
                }
            }
        }

        int[] counts = new int[max + 1];
        int res = 0;
        for (int a : A) {
            int p = ufs.find(a);
            counts[p]++;
            res = Math.max(res, counts[p]);
        }
        return res;
    }

    // UFS without size optimization will TLE.
    static class UnionFindSet {
        private int[] parrents;
        private int[] size;

        public UnionFindSet(int n) {
            parrents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parrents[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if (parrents[i] == i) {
                return i;
            } else {
                return find(parrents[i]);
            }
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                if (size[pa] > size[pb]) {
                    parrents[pb] = pa;
                    size[pa] += size[pb];
                } else {
                    parrents[pa] = pb;
                    size[pb] += size[pa];
                }
            }
        }
    }
}
// @lc code=end
