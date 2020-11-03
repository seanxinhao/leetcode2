import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/*
 * @lc app=leetcode id=968 lang=java
 *
 * [968] Binary Tree Cameras
 */

// @lc code=start
class Solution {
    private int ans = 0;
    private Set<TreeNode> covered = new HashSet<>();

    public int minCameraCover(TreeNode root) {
        covered.add(null);
        camera(root, null);
        return ans;
    }

    // From bottem up.
    private void camera(TreeNode current, TreeNode parent) {
        if (current == null) {
            return;
        }
        camera(current.left, current);
        camera(current.right, current);
        if ((!covered.contains(current.left) || !covered.contains(current.right))
                || (parent == null && !covered.contains(current))) {
            // Place camera when:
            // 1. Any one of children is uncovered;
            // 2. Current is not covered and parent is null;
            ans++;
            covered.add(current.left);
            covered.add(current.right);
            covered.add(current);
            covered.add(parent);
        }
    }
}
// @lc code=end
