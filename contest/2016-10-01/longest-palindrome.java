public class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        boolean odd = false;
        int cnt = 0;
        for (int i = 0; i < 128; i++) {
            if (map[i] % 2 == 1) {
                odd = true;
                cnt += map[i] - 1;
            } else {
                cnt += map[i];
            }
        }
        if (odd) {
            cnt += 1;
        }
        return cnt;
    }
}
