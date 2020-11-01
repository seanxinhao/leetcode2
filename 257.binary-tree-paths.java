import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */

// @lc code=start
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        traverse(results, new ArrayList<>(), root);
        return results;
    }

    private void traverse(List<String> results, List<Integer> path, TreeNode root) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            String s = path.stream().map(String::valueOf).reduce((a, b) -> a + "->" + b).get();
            results.add(s);
        }
        traverse(results, path, root.left);
        traverse(results, path, root.right);
        path.remove(path.size() - 1);
    }
}
// @lc code=end
