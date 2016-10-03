
public class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int lo = 0, hi = sum + 1;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (check(mid, nums, m)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    boolean check(int v, int[] nums, int m) {
        int cnt = 1, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > v) {return false;}
            if (sum + nums[i] > v) {
                sum = 0;
                cnt += 1;
            } 
            sum += nums[i];
        }
        return cnt <= m;
    }
}
