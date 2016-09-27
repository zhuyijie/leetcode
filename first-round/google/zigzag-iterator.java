
public class ZigzagIterator {
    List<Integer>[] v;
    int[] p;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        v = (List<Integer>[]) new List[2]; 
        v[0] = v1; v[1] = v2;
        p = new int[] {-1, -1};
    }
    public int next() {
        if (p[0] == v[0].size() - 1) {
            return v[1].get(++p[1]);
        }    
        if (p[1] == v[1].size() - 1) {
            return v[0].get(++p[0]);
        }
        if (p[0] == p[1]) {
            return v[0].get(++p[0]);
        } else {
            return v[1].get(++p[1]);
        }
    }
    public boolean hasNext() {
        return p[0] < v[0].size() - 1 || p[1] < v[1].size() - 1;
    }
}
