import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
 */

// @lc code=start
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Map<Integer, List<Point>> resMap = new TreeMap<>();
        traverse(root, 0, 0, resMap);
        resMap.entrySet()
                .forEach(entry -> results.add(entry.getValue().stream().sorted(Comparator.comparing(p -> p.value))
                        .sorted(Comparator.comparing(p -> p.yaxis)).map(p -> p.value).collect(Collectors.toList())));
        return results;
    }

    private void traverse(TreeNode root, int xaxis, int yaxis, Map<Integer, List<Point>> resMap) {
        if (root == null) {
            return;
        }
        if (resMap.containsKey(xaxis)) {
            resMap.get(xaxis).add(Point.build(yaxis, root.val));
        } else {
            List<Point> vertiacal = new ArrayList<>();
            vertiacal.add(Point.build(yaxis, root.val));
            resMap.put(xaxis, vertiacal);
        }
        traverse(root.left, xaxis - 1, yaxis + 1, resMap);
        traverse(root.right, xaxis + 1, yaxis + 1, resMap);
    }

    static class Point {
        int yaxis;
        int value;

        public static Point build(int y, int v) {
            Point p = new Point();
            p.yaxis = y;
            p.value = v;
            return p;
        }
    }
}
// @lc code=end
