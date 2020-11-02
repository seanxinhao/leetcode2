import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> results = new ArrayList<>();
        helper(results, root);
        Map<Integer, Integer> map = results.stream().collect(Collectors.toMap(r -> r, r -> 1, (v, newV) -> v + 1));
        int max = map.values().stream().max(Comparator.naturalOrder()).get();
        return map.entrySet().stream().filter(entry -> entry.getValue() == max).map(entry -> entry.getKey())
                .mapToInt(x -> x).toArray();
    }

    private void helper(List<Integer> results, TreeNode root) {
        if (root == null) {
            return;
        }
        results.add(sum(root));
        helper(results, root.left);
        helper(results, root.right);
    }

    private int sum(TreeNode root) {
        int sum = root.val;
        if (root.left != null) {
            sum += sum(root.left);
        }
        if (root.right != null) {
            sum += sum(root.right);
        }
        return sum;
    }
}
// @lc code=end
