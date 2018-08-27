import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-27 15:17
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, k = 0, c = 0;
        while (i < nums1.length && k < nums2.length) {
            if (nums1[i] < nums2[k]) {
                i++;
            } else if (nums1[i] > nums2[k]) {
                k++;
            } else {
                nums1[c] = nums1[i];
                c++;
                i++;
                k++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, c);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] l1 = new int[]{1, 2, 2, 1};
        int[] l2 = new int[]{2, 2};
        int[] intersect = solution.intersect(l1, l2);
        for (int i : intersect) {
            System.out.printf(" " + i);
        }
    }
}



