package can_partition;

import java.util.Arrays;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        Arrays.sort(nums);
        return dfs(nums, nums.length - 1, target);
    }
    boolean dfs(int[] nums, int j, int remain) {
        if (remain == 0) {
            return true;
        }
        if (remain < 0) {
            return false;
        }
        for (int i = j; i >= 0; i--) {
            if (dfs(nums, i - 1, remain - nums[i])) {
                return true;
            }
        }
        return false;
    }
}