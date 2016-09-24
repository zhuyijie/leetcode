public class Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> res = new ArrayList<String>();
        if (nums.length == 0) {
            if (lower == upper) {
                res.add("" + lower);
            } else {
                res.add(lower + "->" + upper);
            }
            return res;
        }
        if (lower < nums[0]) {
            if (nums[0] > lower + 1) {
                res.add(lower + "->" + (nums[0] - 1));
            } else {
                res.add("" + lower);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            int a = nums[i-1];
            int b = nums[i];
            if (a + 1 >= b) {
                continue;
            } else if(a + 2 == b) {
                res.add("" + (a+1));
            } else {
                res.add((a+1) + "->" + (b-1));
            }
        }
        if (upper > nums[nums.length - 1]) {
            if (upper > nums[nums.length - 1] + 1) {
                res.add((nums[nums.length - 1] + 1) + "->" + upper);
            } else {
                res.add("" + upper);
            }
        }
        return res;
    }

}
