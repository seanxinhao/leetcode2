import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
    static class Interval {
        int start;
        int end;

        public static Interval build(int[] pair) {
            Interval interval = new Interval();
            interval.start = pair[0];
            interval.end = pair[1];
            return interval;
        }

        public static Interval build(int start, int end) {
            Interval interval = new Interval();
            interval.start = start;
            interval.end = end;
            return interval;
        }

        public int[] toPair() {
            int[] pair = new int[2];
            pair[0] = this.start;
            pair[1] = this.end;
            return pair;
        }
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<Interval> a = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            a.add(Interval.build(A[i]));
        }
        List<Interval> b = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            b.add(Interval.build(B[i]));
        }

        List<Interval> results = new ArrayList<>();
        int aptr = 0;
        int bptr = 0;
        while (aptr < a.size() && bptr < b.size()) {
            if (a.get(aptr).start >= b.get(bptr).start) {
                if (a.get(aptr).end >= b.get(bptr).end) {
                    if (a.get(aptr).start <= b.get(bptr).end) {
                        results.add(Interval.build(a.get(aptr).start, b.get(bptr).end));
                    }
                    bptr++;
                } else {
                    results.add(Interval.build(a.get(aptr).start, a.get(aptr).end));
                    aptr++;
                }
            } else {
                if (a.get(aptr).end >= b.get(bptr).end) {
                    results.add(Interval.build(b.get(bptr).start, b.get(bptr).end));
                    bptr++;
                } else {
                    if (b.get(bptr).start <= a.get(aptr).end) {
                        results.add(Interval.build(b.get(bptr).start, a.get(aptr).end));
                    }
                    aptr++;
                }
            }
        }

        return results.stream().map(Interval::toPair).toArray(int[][]::new);
    }
}
// @lc code=end
