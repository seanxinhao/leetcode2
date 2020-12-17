/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    private List<Integer> inorder = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        traverse(root);
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i) >= inorder.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        inorder.add(root.val);
        traverse(root.right);
    }
}
// @lc code=end
