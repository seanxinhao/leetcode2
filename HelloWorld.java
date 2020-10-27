import java.util.Arrays;
import java.util.stream.IntStream;

class HelloWorld {
  public static void main(String[] args) {
    HelloWorld s = new HelloWorld();
    int[] nums = { 4, 3, 2, 3, 5, 2, 1 };
    System.out.println(s.canPartitionKSubsets(nums, 4));
  }

  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = IntStream.of(nums).sum();
    if (sum % k != 0) {
      return false;
    }
    Arrays.sort(nums);
    int target = sum / k;
    return helper(nums, new boolean[nums.length], target, 0, k);
  }

  private static boolean helper(int[] nums, boolean[] used, int target, int current, int k) {
    if (k == 0) {
      return current == 0;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      if (nums[i] + current < target) {
        // Add to subset.
        if (helper(nums, used, target, nums[i] + current, k)) {
          return true;
        }
      } else if (nums[i] + current == target) {
        // End subset.
        if (helper(nums, used, target, 0, k - 1)) {
          return true;
        }
      }
      used[i] = false;
    }

    return false;
  }
}