import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, List<Integer>> ansMap = new TreeMap<>();
        traverse(ansMap, root, 0);
        ansMap.entrySet().forEach(entry -> results.add(entry.getValue()));
        return results;
    }

    private void traverse(Map<Integer, List<Integer>> ansMap, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        List<Integer> ans = ansMap.get(level);
        if (ans == null) {
            ans = new ArrayList<>();
            ans.add(root.val);
            ansMap.put(level, ans);
        } else {
            ans.add(root.val);
        }
        traverse(ansMap, root.left, level - 1);
        traverse(ansMap, root.right, level - 1);
    }
}
// @lc code=end
