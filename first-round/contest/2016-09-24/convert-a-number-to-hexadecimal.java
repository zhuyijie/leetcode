public class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        int mask = (1 << 4) - 1;
        StringBuilder sb = new StringBuilder();
        char[] map = new char[16];
        map[10] = 'a'; map[11] = 'b'; map[12] = 'c'; map[13] = 'd'; map[14] = 'e'; map[15] = 'f'; 
        do {
            int part = mask & num;
            if (part < 10) {
                sb.append(part);
            } else {
                sb.append(map[part]);
            }
            num = num >>> 4;
        } while (num != 0);
        return sb.reverse().toString();
    }
}
