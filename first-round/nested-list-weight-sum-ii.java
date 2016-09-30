import static java.lang.Math.*;
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return recSum(nestedList, depth(nestedList));
    }

    int recSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += recSum(ni.getList(), depth - 1);
            }
        }
        return sum;
    }
    
    int depth(List<NestedInteger> nestedList) {
        int ret = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                ret = max(ret, 1);
            } else {
                ret = max(ret, depth(ni.getList()) + 1);
            }
        }
        return ret;
    }
}
