/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        Map<Integer, Integer> abMap = addCountMap(getCountMap(A), getCountMap(B));
        Map<Integer, Integer> cdMap = addCountMap(getCountMap(C), getCountMap(D));
        int counts = 0;
        for (Map.Entry<Integer, Integer> entry : abMap.entrySet()) {
            int num = entry.getKey();
            if (cdMap.containsKey(-num)) {
                counts += entry.getValue() * cdMap.get(-num);
            }
        }
        return counts;
    }

    private Map<Integer, Integer> getCountMap(int[] A) {
        int n = A.length;
        Map<Integer, Integer> counts = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int val = counts.getOrDefault(A[i], 0) + 1;
            counts.put(A[i], val);
        }
        return counts;
    }

    private Map<Integer, Integer> addCountMap(Map<Integer, Integer> aMap, Map<Integer, Integer> bMap) {
        Map<Integer, Integer> sum = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> aEntry : aMap.entrySet()) {
            int a = aEntry.getKey();
            for (Map.Entry<Integer, Integer> bEntry : bMap.entrySet()) {
                int key = aEntry.getKey() + bEntry.getKey();
                int val = sum.getOrDefault(key, 0) + aEntry.getValue() * bEntry.getValue();
                sum.put(key, val);
            }
        }
        return sum;
    }
}
// @lc code=end
