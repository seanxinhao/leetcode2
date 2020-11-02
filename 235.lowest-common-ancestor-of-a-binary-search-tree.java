/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int small, big;
        if (p.val < q.val) {
            small = p.val;
            big = q.val;
        } else {
            small = q.val;
            big = p.val;
        }
        if (root.val == small || root.val == big) {
            return root;
        }
        if (root.val > small && root.val < big) {
            return root;
        }
        if (root.val > small) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < small) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }
}
// @lc code=end
