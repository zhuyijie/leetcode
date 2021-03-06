public class Solution {
    public static void main(String[] args) {
        String res = new Solution().addStrings("321", "999");
        System.out.println(res);
    }
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int carry = 0, i = 0;
        while (i < num1.length() && i < num2.length()) {
            int c = (num1.charAt(i) - '0') + (num2.charAt(i) - '0');
            sb.append((c + carry) % 10);
            carry = (c + carry) / 10;
            i++;
        }
        while (i < num1.length()) {
            int c = num1.charAt(i) - '0';
            sb.append((c + carry) % 10);
            carry = (c + carry) / 10;
            i++;
        }
        while (i < num2.length()) {
            int c = num2.charAt(i) - '0';
            sb.append((c + carry) % 10);
            carry = (c + carry) / 10;
            i++;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
