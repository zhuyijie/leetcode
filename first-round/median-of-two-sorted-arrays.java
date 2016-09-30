import static java.lang.Math.*;
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int k = (len + 1) / 2 - 1;
        double n1 = (double) find(k, nums1, 0, nums2, 0);
        if(len % 2 == 1) {
            return n1;
        } 
        double n2 = (double) find(k + 1, nums1, 0, nums2, 0);
        return (n1 + n2) / 2;
    }

    int find(int k, int[] nums1, int i1, int[] nums2, int i2) {
        if (i1 >= nums1.length) {
            return nums2[i2 + k];
        }
        if (i2 >= nums2.length) {
            return nums1[i1 + k];
        }
        if (k == 0) {
            return min(nums1[i1], nums2[i2]);
        }
        if (k == 1) {
            if (nums1[i1] < nums2[i2]) {
                return find(0, nums1, i1 + 1, nums2, i2);
            } else if (nums1[i1] > nums2[i2]) {
                return find(0, nums1, i1, nums2, i2 + 1);
            } else {
                return nums1[i1];
            }
        }
        int part1 = k / 2, part2 = k - part1;
        if (i1 + part1 >= nums1.length) {
            return find(k - part2, nums1, i1, nums2, i2 + part2);
        } else if (i2 + part2 >= nums2.length) {
            return find(k - part1, nums1, i1 + part1, nums2, i2);
        } else {
            int flag = nums1[i1 + part1] - nums2[i2 + part2];
            if (flag == 0) {
                return nums1[i1 + part1];
            } else if (flag > 0) {
                return find(k - part2, nums1, i1, nums2, i2 + part2); 
            } else {
                return find(k - part1, nums1, i1 + part1, nums2, i2);
            }
        }
    }
}
