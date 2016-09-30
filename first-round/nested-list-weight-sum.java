
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            sum += rec(ni, 1);
        }
        return sum;
    } 

    int rec(NestedInteger i, int level) {
        if (i.isInteger()) {
            return i.getInteger() * level;
        }
        List<NestedInteger> list = i.getList();
        int sum = 0;
        for (NestedInteger ni : list) {
            sum += rec(ni, level + 1);
        }
        return sum;
    }
}
