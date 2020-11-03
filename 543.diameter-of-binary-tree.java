import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
 */

// @lc code=start
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
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
        results.add(maxPath(root.left) + maxPath(root.right) + 1);
        traverse(results, root.left);
        traverse(results, root.right);
    }

    private int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxPath(root.left), maxPath(root.right)) + 1;
    }
}
// @lc code=end
