import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start
class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Choose between grandparent + grandchildren and parent.
        int ll = root.left != null ? rob(root.left.left) : 0;
        int lr = root.left != null ? rob(root.left.right) : 0;
        int rl = root.right != null ? rob(root.right.left) : 0;
        int rr = root.right != null ? rob(root.right.right) : 0;
        return Math.max(root.val + ll + lr + rl + rr, rob(root.left) + rob(root.right));
    }
}
// @lc code=end
