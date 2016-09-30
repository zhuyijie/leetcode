public class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = i;
            for (int j = i; j < nums.length; j++) {
                if (i % 2 == 0 && nums[j] < nums[idx]) {
                    idx = j;
                }
                if (i % 2 == 1 && nums[j] > nums[idx]) {
                    idx = j;
                }
            }
            swap(nums, i, idx);
        }
    }
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
