public class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        int len = target.length();
        List<Integer> sames = new ArrayList<>();
        for (String word : dictionary) {
            if (word.length() != len) {
                continue;
            }
            int bitmap = 0;
            for (int i = 0; i < len; i++) {
                if (target.charAt(i) == word.charAt(i)) {
                    bitmap |= 1 << i;
                }
            }
            sames.add(bitmap);
            if (bitmap == (1 << len) - 1) {
                return target;
            }
        }
        int minMap = (1 << len) - 1;
        bitFor:
        for (int bitmap = 0; bitmap < 1 << len; bitmap++) {
            for (int same : sames) {
                if ((same & bitmap) == bitmap) {
                    continue bitFor;
                }
            }
            if (count(bitmap, len) < count(minMap, len)) {
                minMap = bitmap;
            }
        }
        return trans(target, minMap);
    }
    String trans(String target, int bitmap) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length();) {
            if ((bitmap & 1 << i) != 0) {
                sb.append(target.charAt(i));
                i++;
            } else {
                int iEnd = i + 1;
                while (iEnd < target.length() && (bitmap & i << iEnd) == 0) {
                    iEnd++;
                }
                sb.append(iEnd - i);
                i = iEnd;
            }
        }
        return sb.toString();
    }
    int count(int bitmap, int len) {
        int cnt = 0;
        for (int i = 0; i < len;) {
            if ((bitmap & 1 << i) != 0) {
                i++;
            } else {
                int iEnd = i + 1;
                while (iEnd < len && (bitmap & 1 << iEnd) == 0) {
                    iEnd++;
                }
                i = iEnd;
            }
            cnt++;
        }
        return cnt;
    }
}
