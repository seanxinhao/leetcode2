import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 */

// @lc code=start
class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> results = new ArrayList<>();
        traverse(results, root);
        return results.stream().max(Comparator.naturalOrder()).get();
    }

    private void traverse(List<Integer> results, TreeNode root) {
        if (root == null) {
            return;
        }
        results.add(Math.max(maxPath(root.right) + root.val, Math.max(maxPath(root.left) + root.val,
                Math.max(maxPath(root.left) + maxPath(root.right) + root.val, root.val))));
        traverse(results, root.left);
        traverse(results, root.right);
    }

    private int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(root.val, Math.max(maxPath(root.left) + root.val, maxPath(root.right) + root.val));
    }
}
// @lc code=end
