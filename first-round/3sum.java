public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            } 
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    do {
                        lo++;
                    } while (lo < hi && nums[lo] == nums[lo-1]);
                    do {
                        hi--;
                    } while (lo < hi && nums[hi] == nums[hi+1]);
                }
                if (sum > 0) {
                    hi--;
                }
                if (sum < 0) {
                    lo++;
                }
            }
        }
        return result;
    }
}
