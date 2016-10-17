public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        int i = 0;
        while (i < s.length()) {
            for (int idx = 0; idx <= numRows - 1 && i < s.length(); idx++) {
                rows[idx].append(s.charAt(i++));
            }
            for (int idx = numRows - 2; idx >= 1 && i < s.length(); idx--) {
                rows[idx].append(s.charAt(i++));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }
}
