import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 */

// @lc code=start
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<Integer> results = new ArrayList<>();
        traverse(results, root);
        return results.stream().map(r -> Integer.toString(r)).collect(Collectors.joining(","));
    }

    private void traverse(List<Integer> results, TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(results, root.left);
        traverse(results, root.right);
        results.add(root.val);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        List<Integer> values = Stream.of(data.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        return desHelper(values, 0, values.size() - 1);
    }

    public TreeNode desHelper(List<Integer> data, int start, int end) {
        if (start > end || start < 0 || start > data.size() || end < 0 || end > data.size()) {
            return null;
        }
        int pivot = data.get(end);
        TreeNode root = new TreeNode(pivot);
        int i = start;
        while (i < data.size() && data.get(i) < pivot) {
            i++;
        }
        root.left = desHelper(data, start, i - 1);
        root.right = desHelper(data, i, end - 1);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end
