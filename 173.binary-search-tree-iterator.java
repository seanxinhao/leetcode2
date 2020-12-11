/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
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
class BSTIterator {

    private Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            stack.addLast(curr);
            curr = curr.left;
        }
    }

    public int next() {
        if (hasNext()) {
            TreeNode next = stack.removeLast();
            if (next.right != null) {
                stack.addLast(next.right);
                TreeNode p = next.right.left;
                while (p != null) {
                    stack.addLast(p);
                    p = p.left;
                }
            }
            return next.val;
        }
        return -1;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end
