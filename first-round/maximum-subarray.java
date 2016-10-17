public class Solution {
    public int maxSubArray(int[] nums) {
        int ret = Integer.MIN_VALUE;
        int min = 0,  agg = 0;
        for (int i = 0; i < nums.length; i++) {
            agg += nums[i];
            if (agg - min > ret) {
                ret = agg - min;
            }
            if (min > agg) {
                min = agg;
            }
        }
        return ret;
    }
}
