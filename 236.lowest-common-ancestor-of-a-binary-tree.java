/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode leftp = findNode(root.left, p);
        TreeNode leftq = findNode(root.left, q);
        TreeNode rightp = findNode(root.right, p);
        TreeNode rightq = findNode(root.right, q);
        if ((root.val == p.val && (leftq != null || rightq != null))
                || (root.val == q.val && (leftp != null || rightp != null)) || (root.val == p.val && root.val == q.val)
                || (leftp != null && rightq != null) || (leftq != null && rightp != null)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    private TreeNode findNode(TreeNode root, TreeNode target) {
        if (root == null) {
            return null;
        }
        if (root.val == target.val) {
            return root;
        }
        TreeNode left = findNode(root.left, target);
        TreeNode right = findNode(root.right, target);

        if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
// @lc code=end
