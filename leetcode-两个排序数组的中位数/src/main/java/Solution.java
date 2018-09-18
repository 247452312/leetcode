import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * <p>
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * <p>
 * 你可以假设 nums1 和 nums2 不同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 中位数是 (2 + 3)/2 = 2.5
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-09-03 08:35
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] n2 = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, n2, 0, nums1.length);
        System.arraycopy(nums2, 0, n2, nums1.length, nums2.length);
        Arrays.sort(n2);
        int z = n2.length / 2;
        if (n2.length % 2 == 1) {
            return n2[z];
        } else {
            return (n2[z] + n2[z - 1]) / 2.0;
        }

    }


    public static void main(String[] args) {
        int[] a1 = {1, 4};
        int[] a2 = {2, 3};

        double medianSortedArrays = new Solution().findMedianSortedArrays(a1, a2);
        System.out.println(medianSortedArrays);
    }


    public double batter(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 1) {
            return findKth(nums1, nums2, (m + n + 1) / 2);
        } else {
            return (findKth(nums1, nums2, (m + n) / 2) + findKth(nums1, nums2, (m + n) / 2 + 1)) / 2.0;
        }

    }

    private int findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            return nums2[k - 1];
        }
        if (n == 0) {
            return nums1[k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }
        int idx1 = Math.min(m, k / 2);
        int idx2 = Math.min(n, k / 2);
        if (nums1[idx1 - 1] > nums2[idx2 - 1]) {
            return findKth(nums1, Arrays.copyOfRange(nums2, idx2, n), k - idx2);
        } else {
            return findKth(Arrays.copyOfRange(nums1, idx1, m), nums2, k - idx1);
        }
    }


}
