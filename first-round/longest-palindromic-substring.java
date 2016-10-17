public class Solution {
    public String longestPalindrome(String s) {
        int len = 0;
        String ret = null;
        for (int i = 0; i < s.length(); i++) {
            int lo = i, hi = i;
            while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
                lo--;
                hi++;
            }
            lo++;
            hi--;
            if (hi - lo + 1 > len) {
                ret = s.substring(lo, hi + 1);
                len = hi - lo + 1;
            }
            lo = i; hi = i + 1;
            while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
                lo--;
                hi++;
            }
            lo++;
            hi--;
            if (hi - lo + 1 > len) {
                ret = s.substring(lo, hi + 1);
                len = hi - lo + 1;
            }
        }
        return ret;
    }
}
