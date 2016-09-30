import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }
    int[] colors;
    int[][] edges;
    void run() {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        colors = new int[n + 1]; edges = new int[n - 1][2];
        for (int i = 1; i <= n; i++) {
            colors[i] = cin.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = cin.nextInt();
            edges[i][1] = cin.nextInt();
        }
    }
}
