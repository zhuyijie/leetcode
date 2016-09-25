public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int p = 0;
        while (p < nums.length) {
            int pn = p;
            while (pn + 1 < nums.length && (nums[pn+1] == nums[pn] || nums[pn+1] == nums[pn] + 1)) {
                pn++;
            }
            if (nums[pn] == nums[p]) {
                result.add(String.valueOf(nums[p]));
            } else {
                result.add("" + nums[p] + "->" + nums[pn]);
            }
            p = pn + 1;
        }
        return result;
    }
}
