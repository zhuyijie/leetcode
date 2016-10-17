public class Solution {
    public int romanToInt(String s) {
        int[] map = new int[128];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        int ret = 0;
        for (int i = 0; i < s.length();i++) {
            if (i < s.length() - 1 && map[s.charAt(i)] < map[s.charAt(i+1)]) {
                ret += map[s.charAt(i+1)] - map[s.charAt(i)];
                i++;
            } else {
                ret += map[s.charAt(i)];
            }
        }
        return ret;
    }
}
