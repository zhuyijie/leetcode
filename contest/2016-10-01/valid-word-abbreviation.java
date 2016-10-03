public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wi = 0, ai = 0;
        while (ai < abbr.length() && wi < word.length()) {
            if (Character.isLowerCase(abbr.charAt(ai))) {
                if (word.charAt(wi) != abbr.charAt(ai)) {
                    return false;
                } else {
                    ai++;
                    wi++;
                }
            } else {
                if (abbr.charAt(ai) == '0') {
                    return false;
                }
                int aEnd = ai + 1;
                while (aEnd < abbr.length() && Character.isDigit(abbr.charAt(aEnd))) {
                    aEnd++;
                }
                int len = Integer.parseInt(abbr.substring(ai, aEnd));
                ai = aEnd;
                wi += len;
            }
        }
        return ai == abbr.length() && wi == word.length();
    }
}
