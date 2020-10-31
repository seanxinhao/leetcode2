import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        traverse(results, path, root, sum - root.val);
        return results;
    }

    private void traverse(List<List<Integer>> results, List<Integer> path, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && sum == 0) {
            results.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            path.add(root.left.val);
            traverse(results, path, root.left, sum - root.left.val);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            traverse(results, path, root.right, sum - root.right.val);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end
