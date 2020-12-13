/*
 * @lc app=leetcode id=865 lang=java
 *
 * [865] Smallest Subtree with all the Deepest Nodes
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode[] ans = new TreeNode[1];
        helper(root, ans);
        return ans[0];
    }

    private int helper(TreeNode root, TreeNode[] ans) {
        if (root == null) {
            return 0;
        }
        TreeNode[] leftAns = new TreeNode[1];
        int left = helper(root.left, leftAns);
        TreeNode[] rightAns = new TreeNode[1];
        int right = helper(root.right, rightAns);
        if (left > right) {
            ans[0] = leftAns[0];
            return left + 1;
        } else if (left < right) {
            ans[0] = rightAns[0];
            return right + 1;
        } else {
            ans[0] = root;
            return left + 1;
        }
    }
}
// @lc code=end
