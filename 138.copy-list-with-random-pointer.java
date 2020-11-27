import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node ptr = head;

        while (ptr != null) {
            map.putIfAbsent(ptr, new Node(ptr.val));
            Node ptrCopy = map.get(ptr);
            if (ptr.next != null) {
                map.putIfAbsent(ptr.next, new Node(ptr.next.val));
                ptrCopy.next = map.get(ptr.next);
            }
            if (ptr.random != null) {
                map.putIfAbsent(ptr.random, new Node(ptr.random.val));
                ptrCopy.random = map.get(ptr.random);
            }
            ptr = ptr.next;
        }

        return map.get(head);
    }
}
// @lc code=end
