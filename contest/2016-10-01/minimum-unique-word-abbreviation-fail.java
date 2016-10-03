
public class Solution {
    public String minAbbreviation(String target, List<String> dictionary) {
        int len = target.length();
        Set<String>[] map = (Set<String>[]) new Set[len];
        for (int i = 0; i < len; i++) {
            map[i] = new HashSet<String>();
        }
        int min = len;
        String abbr = target;
        boolean hasWord = false;;
        for (String word : dictionary) {
            if (word.length() != len) {
                continue;
            }
            hasWord = true;
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) == target.charAt(i)) {
                    map[i].add(word);
                }
            }
        }
        if (!hasWord) {
            return String.valueOf(target.length());
        }
        int up = 1 << len;
        for (int bitmap = 1; bitmap < up; bitmap++) {
            int t = count(bitmap, len);
            if (t < min && valid(bitmap, len,  map)) {
                min = t;
                abbr = trans(bitmap, len, target);
            }
        }
        return abbr;
    }
    boolean valid(int bitmap, int len, Set<String>[] map) {
        int i = 0;
        while ((bitmap & (1 << i)) == 0) {
            i++;
        } 
        Set<String> base = new HashMap<>(map[i]);
        i++;
        while (i < len) {
            if ((bitmap & (1 << i)) != 0) {
                base.retainAll(map[i]);
            }
            i++;
        }
        return base.isEmpty();
    }
    String trans(int bitmap, int len, String target) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        do {
            if ((bitmap & (1 << i)) == 0) {
                int iEnd = i + 1;
                while (iEnd < len && (bitmap & (1 << iEnd)) == 0) {
                    iEnd++;
                }
                sb.append(iEnd - i);
                i = iEnd;
            } else {
                sb.append(target.charAt(i));
                i = i++;
            }
        } while (i < len);
        return sb.toString();
    }
    int count(int bitmap, int len) {
        int cnt = 0, i = 0;
        do {
            if ((bitmap & (1 << i)) == 0) {
                while (i < len && (bitmap & (1 << i)) == 0) {
                    i++;
                }
            } else {
                i++;
            }
            cnt++;
        } while (i < len);
        return cnt;
    }
}
