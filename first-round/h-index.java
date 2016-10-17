public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 1;
        while (i <= citations.length && citations[citations.length - i] >= i) {
            i++;
        }
        return --i;
    }
}
