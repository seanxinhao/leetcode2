import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<String> results = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.removeFirst();
            if (current.val == Integer.MAX_VALUE) {
                results.add("null");
            } else {
                results.add(Integer.toString(current.val));
                if (current.left == null) {
                    queue.addLast(new TreeNode(Integer.MAX_VALUE));
                } else {
                    queue.addLast(current.left);
                }
                if (current.right == null) {
                    queue.addLast(new TreeNode(Integer.MAX_VALUE));
                } else {
                    queue.addLast(current.right);
                }
            }
        }
        int i = results.size() - 1;
        while (results.get(i).equals("null")) {
            results.remove(i);
            i--;
        }
        return "[" + results.stream().collect(Collectors.joining(",")) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        // Get rid of the brackets.
        data = data.substring(1, data.length() - 1);
        List<Integer> values = Stream.of(data.split(",")).map(element -> {
            if (element.equals("null")) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.valueOf(element);
            }
        }).collect(Collectors.toList());
        Deque<Integer> valQueue = new ArrayDeque<>(values);
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        TreeNode root = new TreeNode();
        nodeQueue.addLast(root);
        while (!valQueue.isEmpty()) {
            TreeNode node = nodeQueue.removeFirst();
            if (!valQueue.isEmpty()) {
                node.val = valQueue.removeFirst();
                if (node.val != Integer.MAX_VALUE) {
                    TreeNode nodeLeft = new TreeNode(Integer.MAX_VALUE);
                    TreeNode nodeRight = new TreeNode(Integer.MAX_VALUE);
                    node.left = nodeLeft;
                    node.right = nodeRight;
                    nodeQueue.addLast(nodeLeft);
                    nodeQueue.addLast(nodeRight);
                }
            }
        }
        removeDummyNode(root);
        return root;
    }

    private void removeDummyNode(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.val == Integer.MAX_VALUE) {
            root.left = null;
        }
        if (root.right != null && root.right.val == Integer.MAX_VALUE) {
            root.right = null;
        }
        removeDummyNode(root.left);
        removeDummyNode(root.right);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
