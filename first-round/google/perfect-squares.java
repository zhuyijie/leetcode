import static java.lang.Math.*;
public class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE); dp[0] = 0;
        for (int k = 1; k * k <= n; k++) {
            int vol = k*k;
            for (int v = vol; v <= n; v++) {
                dp[v] = min(dp[v], dp[v-vol] + 1);
            } 
        }
        return dp[n];
    }
}
