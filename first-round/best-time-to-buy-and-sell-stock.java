public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, ret = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                ret = Math.max(max - prices[i], ret);
            }
        }
        return ret;
    }
}
