/*
 * @lc app=leetcode id=1302 lang=java
 *
 * [1302] Deepest Leaves Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Sum result = traverse(root);
        return result.sum;
    }

    private static Sum traverse(TreeNode root) {
        if (root == null) {
            return Sum.build(0, 0);
        }
        Sum left = traverse(root.left);
        Sum right = traverse(root.right);
        if (left.depth == 0 && right.depth == 0) {
            return Sum.build(1, root.val);
        } else if (left.depth == right.depth) {
            return Sum.build(left.depth + 1, left.sum + right.sum);
        } else if (left.depth > right.depth) {
            return Sum.build(left.depth + 1, left.sum);
        } else {
            return Sum.build(right.depth + 1, right.sum);
        }
    }

    public static class Sum {
        int depth;
        int sum;

        public static Sum build(int d, int s) {
            Sum object = new Sum();
            object.depth = d;
            object.sum = s;
            return object;
        }
    }
}
// @lc code=end
