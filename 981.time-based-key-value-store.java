import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start
class TimeMap {

    static class Node {
        String value;
        int timestamp;

        static Node build(String value, int timestamp) {
            Node n = new Node();
            n.value = value;
            n.timestamp = timestamp;
            return n;
        }
    }

    Map<String, Set<Node>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Set<Node> set = map.getOrDefault(key,
                new TreeSet<>(Comparator.<Node>comparingInt(e -> e.timestamp).reversed()));
        set.add(Node.build(value, timestamp));
        map.put(key, set);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        } else {
            Set<Node> set = map.get(key);
            for (Node n : set) {
                if (n.timestamp <= timestamp) {
                    return n.value;
                }
            }
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */
// @lc code=end
