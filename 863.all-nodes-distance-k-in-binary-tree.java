/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        helper(root, target, K);
        return ans;
    }

    private int helper(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            locate(root, 0, k);
            return 0;
        }
        int left = helper(root.left, target, k);
        int right = helper(root.right, target, k);
        if (left >= 0) {
            int d = left + 1;
            if (d - k == 0) {
                ans.add(root.val);
            } else if (d - k < 0) {
                locate(root.right, 1, k - d);
            }
            return d;
        }
        if (right >= 0) {
            int d = right + 1;
            if (d - k == 0) {
                ans.add(root.val);
            } else if (d - k < 0) {
                locate(root.left, 1, k - d);
            }
            return d;
        }
        return -1;
    }

    private void locate(TreeNode root, int depth, int k) {
        if (root == null) {
            return;
        }
        if (depth == k) {
            ans.add(root.val);
            return;
        }
        locate(root.left, depth + 1, k);
        locate(root.right, depth + 1, k);
    }
}
// @lc code=end
