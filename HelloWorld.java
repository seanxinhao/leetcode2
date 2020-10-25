import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HelloWorld {
  public static void main(String[] args) {
    HelloWorld s = new HelloWorld();
    int[] A = { 1, 1, 2 };
    s.permuteUnique(A);
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    Arrays.sort(nums);
    Arrays.fill(used, false);
    helper(results, new ArrayList<>(), nums, used, 0);
    return results;
  }

  private static void helper(List<List<Integer>> results, List<Integer> tuple, int[] nums, boolean[] used, int depth) {
    if (depth == nums.length) {
      results.add(new ArrayList<>(tuple));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i] == true) {
        continue;
      }
      tuple.add(nums[i]);
      used[i] = true;
      helper(results, tuple, nums, used, depth + 1);
      tuple.remove(tuple.size() - 1);
      used[i] = false;
    }
  }
}