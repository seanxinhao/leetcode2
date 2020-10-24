import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=855 lang=java
 *
 * [855] Exam Room
 */

// @lc code=start
class ExamRoom {
    private final SortedSet<Integer> seatNumber;
    private final int N;

    public ExamRoom(int N) {
        this.seatNumber = new TreeSet<>();
        this.N = N;
    }

    public int seat() {
        if (seatNumber.isEmpty()) {
            seatNumber.add(0);
            return 0;
        } else if (seatNumber.size() == 1) {
            int bestSeat = 0;
            int num = seatNumber.first();
            if (num < this.N / 2) {
                bestSeat = this.N - 1;
            } else {
                bestSeat = 0;
            }
            seatNumber.add(bestSeat);
            return bestSeat;
        } else {
            Iterator<Integer> p1 = seatNumber.iterator();
            Iterator<Integer> p2 = seatNumber.iterator();
            p2.next();
            int bestSeat = 0;
            int largestDist = 0;

            if (!seatNumber.contains(0)) {
                largestDist = seatNumber.first();
            }

            while (p2.hasNext()) {
                int num1 = p1.next();
                int num2 = p2.next();
                int seat = (num2 - num1) / 2 + num1;
                int localDist = seat - num1;
                if (localDist > largestDist) {
                    largestDist = localDist;
                    bestSeat = seat;
                }
            }

            if (!seatNumber.contains(this.N - 1)) {
                int localDist = this.N - 1 - seatNumber.last();
                if (localDist > largestDist) {
                    largestDist = localDist;
                    bestSeat = this.N - 1;
                }
            }

            seatNumber.add(bestSeat);
            return bestSeat;
        }
    }

    public void leave(int p) {
        seatNumber.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such: ExamRoom obj =
 * new ExamRoom(N); int param_1 = obj.seat(); obj.leave(p);
 */
// @lc code=end
