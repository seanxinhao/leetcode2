import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> map = new HashMap<>();
        Deque<Node> q = new ArrayDeque<>();
        q.addLast(node);

        while (!q.isEmpty()) {
            Node curr = q.removeFirst();
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            map.putIfAbsent(curr, new Node(curr.val));
            Node newNode = map.get(curr);
            curr.neighbors.forEach(child -> {
                map.putIfAbsent(child, new Node(child.val));
                q.addLast(child);
                newNode.neighbors.add(map.get(child));
            });
        }

        return map.get(node);
    }
}
// @lc code=end
