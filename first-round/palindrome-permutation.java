public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        boolean odd = false;
        for (int i = 0; i < 128; i++) {
            if (map[i] % 2 == 0) {
                continue;
            }
            if (odd == true) {
                return false;
            }
            odd = true;
        }
        return true;
    }
}
