public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        str = str.trim();
        int sign = 1;
        long n = 0;
        if (str.charAt(0) == '-') {
            sign = -1;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i == 0 && (ch == '+' || ch == '-')) {
                continue;
            }
            if (!Character.isDigit(ch)) {
                break;
            }
            n = 10 * n + (str.charAt(i) - '0') * sign;
            if (n > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } 
            if (n < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) n;
    }
}
