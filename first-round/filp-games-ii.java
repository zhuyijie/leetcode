public class Solution {

    public boolean canWin(String s) {
        List<String> nextMoves = generatePossibleNextMoves(s);    
        for (String it : nextMoves) {
            if (!canWin(it)) {
                return true;
            }
        }
        return false;
    }

    public List<String> generatePossibleNextMoves(String s) {
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                ret.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length()));
            }
        }
        return ret;
    }
}
