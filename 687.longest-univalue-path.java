import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
 */

// @lc code=start
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> results = new ArrayList<>();
        traverse(results, root);
        return results.stream().max(Comparator.naturalOrder()).get() - 1;
    }

    private void traverse(List<Integer> results, TreeNode root) {
        if (root == null) {
            return;
        }
        results.add(maxPath(root.left, root.val) + maxPath(root.right, root.val) + 1);
        traverse(results, root.left);
        traverse(results, root.right);
    }

    private int maxPath(TreeNode root, int target) {
        if (root == null || root.val != target) {
            return 0;
        }
        return Math.max(maxPath(root.left, target), maxPath(root.right, target)) + 1;
    }
}
// @lc code=end
