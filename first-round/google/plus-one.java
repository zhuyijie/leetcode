public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        int carry = 1;
        int p = digits.length - 1;
        do {
            int v = digits[p];
            digits[p] = (v + carry) % 10;
            carry = (v + carry) / 10;
            p--;
        } while (p >= 0 && carry != 0);
        if (carry != 0) {
            int[] res = new int[digits.length + 1];
            res[0] = carry;
            return res;
        } else {
            return digits;
        }
    }
}
