public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        x = Math.abs(x);
        int hi = 1, lo = 1;
        while (hi <= x / 10) {
            hi *= 10;
        }
        while (hi > lo) {
            if (x / hi % 10 != x / lo % 10) {
                return false;
            }
            hi /= 10;
            lo *= 10;
        }
        return true;
    }
}
