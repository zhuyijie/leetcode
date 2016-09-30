public class Solution {
    public int[][] reconstructQueue(int[][] peoples) {
        int len = peoples.length;
        People[] objs = new People[len];
        for (int i = 0; i < len; i++) {
            objs[i] = new People(peoples[i][0], peoples[i][1]);
        }
        Arrays.sort(objs);
        int[][] result = new int[len][2];
        for (int i = 0; i < len; i++) {
            result[i][0] = -1;
        }
        for (People p : objs) {
            int k = p.k, h = p.h, idx = 0;
            while (k > 0 || result[idx][0] != -1) {
                if (result[idx][0] != -1 && result[idx][0] < h) {
                    idx++;
                    continue;
                }
                k--;
                idx++;
            }
            result[idx][0] = p.h;
            result[idx][1] = p.k;
        }
        return result;
    }
}
class People implements Comparable<People> {
    int h, k;
    public People(int h, int k) {
        this.h = h; this.k = k;
    }
    public int compareTo(People p) {
        if (this.h != p.h) {
            return this.h - p.h;
        } 
        return this.k - p.k;
    }
}
