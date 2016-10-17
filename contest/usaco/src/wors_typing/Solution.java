package wors_typing;

public class Solution {
    public static void main(String[] args) {
        int cnt = new Solution().wordsTyping(new String[]{"h"}, 2, 3);
        System.out.println(cnt);
    }
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int ri = 1, remainCols = cols, si = 0, cnt = 0;
        int sentenceLen = 0;
        for (String s : sentence) {
            sentenceLen += s.length() + 1;
        }
        sentenceLen -= 1;
        while (ri <= rows) {
            if (remainCols != cols) {
                remainCols -= 1;
            }
            if (remainCols >= sentenceLen) {
                cnt += remainCols / (sentenceLen + 1);
                remainCols %= (sentenceLen + 1);
            }
            if (remainCols < sentence[si].length()) {
                ri++;
                remainCols = cols;
            } else {
                remainCols -= sentence[si].length();
                si++;
                if (si == sentence.length) {
                    cnt++;
                    si = 0;
                }
            }
        }
        return cnt;
    }
}