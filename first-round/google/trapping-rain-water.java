import static java.lang.Math.*;
public class Solution {
    public int trap(int[] height) {
        int lo = 0, hi = height.length - 1;
        int rain = 0;
        while (lo < hi) {
            if (height[lo] < height[hi]) {
                rain += height[lo + 1] < height[lo] ? height[lo] - height[lo + 1] : 0;
                height[lo + 1] = max(height[lo], height[lo + 1]);
                lo++;
            } else {
                rain += height[hi - 1] < height[hi] ? height[hi] - height[hi - 1] : 0;
                height[hi - 1] = max(height[hi], height[hi - 1]);
                hi--;
            }
        }
        return rain;
    }
}
