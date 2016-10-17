public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int m = 0, counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counter == 0) {
                m = nums[i];
                counter = 1;
            } else {
                if (nums[i] == m) {
                    counter++;
                } else {
                    counter--;
                }
            }
        }
        return m;
    }
}
