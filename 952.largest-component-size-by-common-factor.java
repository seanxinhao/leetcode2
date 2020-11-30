import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=952 lang=java
 *
 * [952] Largest Component Size by Common Factor
 */

// @lc code=start
class Solution {
    public int largestComponentSize(int[] A) {
        int n = A.length;
        int max = IntStream.of(A).max().getAsInt();
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
        for (int i = 0; i < n; i++) {
            for (int f = 2; f * f <= A[i]; f++) {
                if (A[i] % f == 0) {
                    ufs.union(A[i], f);
                    ufs.union(A[i], A[i] / f);
                }
            }
        }

        Map<Integer, Integer> counts = new LinkedHashMap<>(n);
        max = 0;
        for (int i = 0; i < n; i++) {
            int p = ufs.find(A[i]);
            int count = counts.getOrDefault(p, 0) + 1;
            counts.put(p, count);
            max = Math.max(max, count);
        }
        return max;
    }

    class UnionFindSet {
        int[] parrents;

        public UnionFindSet(int n) {
            parrents = new int[n];
            for (int i = 0; i < n; i++) {
                parrents[i] = i;
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
            parrents[find(a)] = parrents[find(b)];
        }
    }
}
// @lc code=end
