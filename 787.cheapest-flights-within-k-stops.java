/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<Flight>> graph = new HashMap<>();
        for (int[] flight : flights) {
            List<Flight> val = graph.getOrDefault(flight[0], new ArrayList<>());
            val.add(new Flight(flight[1], flight[1], flight[2]));
            graph.put(flight[0], val);
        }
        Map<Integer, Integer> costMap = new HashMap<>();
        Deque<State> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.addLast(new State(src, 0));
        int stops = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                State currState = q.removeFirst();
                int curr = currState.stop;
                int paid = currState.paid;
                for (Flight flight : graph.getOrDefault(curr, new ArrayList<>())) {
                    int to = flight.to;
                    int totalPay = paid + flight.price;
                    if (totalPay < costMap.getOrDefault(to, Integer.MAX_VALUE) && stops <= K) {
                        costMap.put(to, totalPay);
                        q.addLast(new State(to, totalPay));
                    }
                }
            }
            stops++;
        }
        return costMap.getOrDefault(dst, -1);
    }

    class Flight {
        int from;
        int to;
        int price;

        public Flight(int from, int to, int price) {
            this.from = from;
            this.to = to;
            this.price = price;
        }
    }

    // Note that the paid money for same stop could be different in different round.
    class State {
        int stop;
        int paid;

        public State(int stop, int paid) {
            this.stop = stop;
            this.paid = paid;
        }
    }
}
// @lc code=end
