package maximum_subarray;

public class MaxSubarray {

  public int maxSubArray(int[] nums) {
    int M = nums[0];
    int m = nums[0];

    for (int i = 1; i < nums.length; i++) {
      m = Math.max(nums[i], m + nums[i]);
      M = Math.max(m, M);
    }

    return M;
  }
}
