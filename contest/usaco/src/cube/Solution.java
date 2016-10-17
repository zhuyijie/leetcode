package cube;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }
    int q, n, cn;
    int[] cube;
    int[][] dp;
    int[] res;
    private void buildDp() {
        for (int x = 0; x < cn; x++) {
            for (int y = x; y < cn; y++) {
                int x1 = x / (n*n), x2 = (x % (n*n)) / n, x3 = x % n;
                int y1 = y / (n*n), y2 = (y % (n*n)) / n, y3 = y % n;
                if (y1 < x1 || y2 < x2 || y3 < x3) {
                    continue;
                }
                dp[x][y] = cube[y];
                if (y1 > x1) {
                    dp[x][y] = Math.max(dp[x][y], dp[x][y - n*n]);
                }
                if (y2 > x2) {
                    dp[x][y] = Math.max(dp[x][y], dp[x][y - n]);
                }
                if (y3 > x3) {
                    dp[x][y] = Math.max(dp[x][y], dp[x][y - 1]);
                }
                
                if ((y1 - x1 == y2 - x2) && (y1 - x1 == y3 - x3) 
                       && (y1 - x1 + 1 == dp[x][y])) {
                    res[y1-x1]++;
                }
            }
        }
    }
    private void run() {
        Scanner cin = new Scanner(System.in);
        q = cin.nextInt();
        for (int qi = 1; qi <= q; qi++) {
            n = cin.nextInt();
            res = new int[n];
            cn = n * n * n;
            cube = new int[cn];
            dp = new int[cn][cn];
            for (int cni = 0; cni < cn; cni++) {
                cube[cni] = cin.nextInt();
            }
            buildDp();
            StringBuilder sb = new StringBuilder();
            for (int ni = 0; ni < n; ni++) {
                sb.append(res[ni]);
                if (ni != n - 1) {
                    sb.append(' ');
                }
            }
            System.out.println(sb.toString());
        }
    }
}