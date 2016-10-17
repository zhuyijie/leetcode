public class Solution {
    public String reverseWords(String s) {
        char[] arr = s.trim().toCharArray();
        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] != ' ') {
                arr[i++] = arr[j++];
            } else {
                int jEnd = j + 1;
                while (jEnd < arr.length && arr[jEnd] == ' ') {
                    jEnd++;
                }
                arr[i++] = ' ';
                j = jEnd;
            }
        }
        int len = i;
        while (i < arr.length) {
            arr[i++] = ' ';
        }
        reverse(arr, 0, len - 1);
        int lo = 0;
        while (lo < len) {
            int idx = lo;
            while (idx < len && arr[idx] != ' ') {
                idx++;
            }
            reverse(arr, lo, idx - 1);
            lo = idx + 1;
        }
        return new String(arr).trim();


    }
    void reverse(char[] arr, int lo, int hi) {
        while (lo < hi) {
            swap(arr, lo, hi);
            lo++; hi--;
        }
    }
    void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
